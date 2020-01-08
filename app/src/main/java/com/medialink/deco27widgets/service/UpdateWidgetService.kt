package com.medialink.deco27widgets.service

import android.app.job.JobParameters
import android.app.job.JobService
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.widget.RemoteViews
import com.medialink.deco27widgets.NumberGenerator
import com.medialink.deco27widgets.R
import com.medialink.deco27widgets.RandomNumberWidget

class UpdateWidgetService: JobService() {
    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        val manager = AppWidgetManager.getInstance(this)
        val view = RemoteViews(packageName, R.layout.random_number_widget)
        val theWidget = ComponentName(this, RandomNumberWidget::class.java)
        val lastUpdate = "Random ${NumberGenerator.generate(100)}"
        view.setTextViewText(R.id.appwidget_text, lastUpdate)

        manager.updateAppWidget(theWidget, view)
        jobFinished(params, false)
        return true
    }
}