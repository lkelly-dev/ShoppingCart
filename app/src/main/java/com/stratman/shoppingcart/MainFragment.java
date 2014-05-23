package com.stratman.shoppingcart;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    private ArrayList<MyItem> items = new ArrayList<MyItem>();
    private LinearLayout layout; // = (LinearLayout) getView().findViewById(R.id.testing);
    private ImageButton bAdd = null;
    private TextView itemText = null;
    private Button actionBarTrash = null;

    public static Fragment newInstance(Context context ) {
        MainFragment f = new MainFragment();
        return f;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        bAdd = (ImageButton) rootView.findViewById(R.id.addItemButton);
        itemText = (TextView) rootView.findViewById(R.id.itemText);
        actionBarTrash = (Button) rootView.findViewById(R.id.delete_item);
        bAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addItemButton:
                        // your stuff here
                        addItem(v);
                        break;
                    case R.id.delete_item:
                        deleteItem();
                        break;
                    default:
                        break;
                }

            }
        });
        layout = (LinearLayout)rootView.findViewById(R.id.testing);
        Context context = getActivity();
        for(int i = 0; i < items.size(); i++)
        {
            MyItem temp = new MyItem(context, items.get(i).getTitle());
            layout.addView(temp);
        }
        //MyItem test = new MyItem(context,"Apples");
        //layout.addView(test);

        return rootView;
    }



    public void addItem(View view) {

        //TextView itemText = (TextView) view.findViewById(R.id.itemText);
        final String newItemName = itemText.getText().toString();
        //final String newItemName = "YOLO";
        Context context = getActivity();

        if ("".equals(newItemName)) {
            Toast.makeText(context, "Please enter an item!", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        // Add new item to list

        context = getActivity();
        final MyItem newitem = new MyItem(context, newItemName);
        items.add(newitem);
        layout.addView(newitem);


        // Clear input field
        itemText.setText("");

        // Hide keyboard
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(itemText.getWindowToken(), 0);

    }

    public void deleteItem()
    {
        ArrayList<Integer> tempArray = new ArrayList<Integer>();
        for(int i = 0; i < items.size(); i++)
        {
            MyItem temp = items.get(i);
            if(temp.isChecked()) {
                layout.removeView(temp);
                tempArray.add(i);

            }
        }
        for(int i = 0; i < tempArray.size(); i++){
            items.remove(tempArray.get(i));
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.delete, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_item:
                Log.w("myApp", "Fucking broken");
                deleteItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void alphabeticOrdering(){
        String [] tempArray = new String[items.size()];
        for (int i = 0; i < items.size(); i++){
            MyItem t = items.get(i);
            tempArray[i] = t.getTitle();
        }



    }

    public void checkedItemsLast(){
        for(int i = 0 ; i < items.size(); i++){
            if(items.get(i).isChecked()){

            }
        }
    }





}