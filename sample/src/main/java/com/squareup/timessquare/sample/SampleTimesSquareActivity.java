package com.squareup.timessquare.sample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;
import com.squareup.timessquare.DefaultDayViewAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import static android.widget.Toast.LENGTH_SHORT;

public class SampleTimesSquareActivity extends Activity {
  private static final String TAG = "SampleTimesSquareActivi";
  private CalendarPickerView calendar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dialog_customized);

    final Calendar nextYear = Calendar.getInstance();
    nextYear.add(Calendar.YEAR, 1);

    final Calendar lastYear = Calendar.getInstance();
    lastYear.add(Calendar.YEAR, -1);

    calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
    calendar.init(lastYear.getTime(), nextYear.getTime()) //
            .inMode(SelectionMode.RANGE) //
            .withSelectedDate(new Date());


      SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
      String strdate = "16-06-2017";
      String strdate2 = "14-06-2017";

      try {
          Date newdate = dateformat.parse(strdate);
          Date newdate2 = dateformat.parse(strdate2);
          ArrayList<Date> arrayList = new ArrayList<>();
          arrayList.add(newdate);
          arrayList.add(newdate2);
          calendar.highlightDates(arrayList);
      } catch (ParseException e) {
          e.printStackTrace();
      }

      ArrayList<Integer> list = new ArrayList<>();
      list.add(2);
      list.add(3);

      calendar.deactivateDates(list);

      //initButtonListeners(nextYear, lastYear);
  }
}

