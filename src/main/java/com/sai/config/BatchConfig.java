package com.sai.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sai.processer.Processor;
import com.sai.reader.Reader;
import com.sai.writer.Writer;

@Configuration
public class BatchConfig {

	@Autowired
    public JobBuilderFactory jobBuilderFactory;
 
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Bean("myTestJob_1")
    @Qualifier("myTestJob_1")
    public Job job1() {
        return jobBuilderFactory.get("myTestJob_1")
                .incrementer(new RunIdIncrementer())
                .flow(step1()).next(step2())
                .end()
                .build();
    }
    @Bean
    @Qualifier("myTestJob_2")
    public Job job2() {
        return jobBuilderFactory.get("myTestJob_2")
                .incrementer(new RunIdIncrementer())
                .flow(step1()).next(step2())
                .end()
                .build();
    }
 
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<String, String> chunk(1)
                .reader(new Reader())
                .processor(new Processor())
                .writer(new Writer())
                .build();
    }
    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .<String, String> chunk(1)
                .reader(new Reader())
                .processor(new Processor())
                .writer(new Writer())
                .build();
    }
	
	
}
