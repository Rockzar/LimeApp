/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.limecreativelabs.app.multiselectlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.actionbarsherlock.view.Menu;
import com.limecreativelabs.app.R;
import com.limecreativelabs.app.shared.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MultiSelectGridActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private GridView mGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_multiselect_grid);

        List<String> items = new ArrayList<String>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        items.add("Item 5");
        items.add("Item 6");
        items.add("Item 7");
        items.add("Item 8");
        items.add("Item 9");
        items.add("Item 10");

        mGrid = (GridView) findViewById(android.R.id.list);

        BaseAdapter adapter = new SelectionAdapter(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, items, mGrid);

        mGrid.setOnItemClickListener(this);
        mGrid.setAdapter(adapter);

        setupActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getSupportMenuInflater().inflate(R.menu.multiselect, menu);
        return true;
    }

    private void setupActionBar() {
        mGrid.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String message = String.format("%s %s", (position + 1), this.getString(R.string.clicked));

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}