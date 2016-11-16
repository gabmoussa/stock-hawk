package com.sam_chordas.android.stockhawk.ui;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.sam_chordas.android.stockhawk.R;

/**
 * Created by Administrator on 2016-08-19.
 */
public class WidgetActivity extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.simple_widget);
            views.setTextViewText(R.id.appwidget_text, context.getString(R.string.widget_title));
            views.setRemoteAdapter(0, R.id.widget_list,
                    new Intent(context, WidgetViewsService.class));

            Intent appIntent = new Intent(context, MyStocksActivity.class);
            PendingIntent appPendingIntent = PendingIntent.getActivity(context, 0, appIntent, 0);

            views.setOnClickPendingIntent(R.id.appwidget_text, appPendingIntent);

            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}