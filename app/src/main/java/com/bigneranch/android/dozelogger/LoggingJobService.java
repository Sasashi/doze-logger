package com.bigneranch.android.dozelogger;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build.VERSION_CODES;

@TargetApi(VERSION_CODES.LOLLIPOP)
public class LoggingJobService extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        if (params.getJobId() == 1) {
            PermanentLoggerUtil.logMessage(this, "Repeating Job onStartJob, jobId: " + params.getJobId());
        } else {
            PermanentLoggerUtil.logMessage(this, "Chargin Job onStartJob, jobId: " + params.getJobId());
        }
        PermanentLoggerUtil.logStatus(this);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        PermanentLoggerUtil.logMessage(this, "JobService onStopJob, jobId: " + params.getJobId());
        return false;
    }
}
