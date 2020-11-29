package me.liuweiqiang.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobStep {

    @Bean
    public Job first(JobBuilderFactory jobBuilderFactory, Step step) {
        System.out.println("Job");
        return jobBuilderFactory.get("first")
                .start(step).build();
    }

    @Bean
    public Step firstStep(StepBuilderFactory stepBuilderFactory) {
        System.out.println("Step");
        return stepBuilderFactory.get("firstStep")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("test");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Job sec(JobBuilderFactory jobBuilderFactory, Step step) {
        return jobBuilderFactory.get("sec")
                .start(step).build();
    }
}
