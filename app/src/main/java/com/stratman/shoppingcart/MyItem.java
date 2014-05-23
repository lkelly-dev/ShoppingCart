package com.stratman.shoppingcart;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MyItem extends RelativeLayout
    {
        private TextView title; //The title of this item
        private CheckBox checkBox;
        private String price;




        public MyItem(Context context, String name)
        {
            super(context); //Must call the super constructor


            setBackgroundResource(R.drawable.cards);

            setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT ));

            setPadding(45,45,45,45);



            title = new TextView(context);
            title.setText(name);
            title.setTextSize(28);
            title.setTextColor(Color.BLACK);





            LayoutParams titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            titleParams.addRule(RelativeLayout.CENTER_VERTICAL);
            titleParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);



            checkBox = new CheckBox(context);
            LayoutParams checkParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            checkParams.addRule(RelativeLayout.CENTER_VERTICAL);
            checkParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            checkBox.setPadding(10,10,10,10);



            //Add the views to this layout
            addView(title, titleParams);
            addView(checkBox, checkParams);


            checkBox.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    //Tells us if the checkbox is checked
                    boolean isChecked = checkBox.isChecked();

                    //Tells us the title of this item
                    //String name = title.getText().toString();

                    if (isChecked) {
                        title.setPaintFlags(title.getPaintFlags()
                                | Paint.STRIKE_THRU_TEXT_FLAG);
                        title.setTextColor(Color.GRAY);
                    } else {
                        title.setPaintFlags(title.getPaintFlags()
                                & (~Paint.STRIKE_THRU_TEXT_FLAG));
                        title.setTextColor(Color.BLACK);
                    }

                    //INSERT STUFF HERE: So now you can do whatever you need to with the name variable and the isCheckedVariable when the box is clicked
                }
            });



            title.setOnLongClickListener(new OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {


                    //INSERT STUFF HERE: So now you can do whatever you need to with the name variable and the isCheckedVariable when the box is clicked
                    return false;
                }
            });


        }

        public void setPrice(String price){
            this.price = price;
        }


        public boolean isChecked()
        {
            return checkBox.isChecked();
        }

        public String getTitle()
        {
            return title.getText().toString();
        }


    }

