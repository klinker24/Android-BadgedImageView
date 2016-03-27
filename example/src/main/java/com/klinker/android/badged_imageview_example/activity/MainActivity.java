/*
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */

package com.klinker.android.badged_imageview_example.activity;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.klinker.android.badged_imageview.BadgedImageView;
import com.klinker.android.badged_imageview_example.R;

public class MainActivity extends AppCompatActivity {

    private BadgedImageView badgedIv1;
    private BadgedImageView badgedIv2;
    private BadgedImageView badgedIv3;
    private BadgedImageView badgedIv4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findBadges();
        touchBadges();
    }

    private void findBadges() {
        badgedIv1 = (BadgedImageView) findViewById(R.id.badge_1);
        badgedIv2 = (BadgedImageView) findViewById(R.id.badge_2);
        badgedIv3 = (BadgedImageView) findViewById(R.id.badge_3);
        badgedIv4 = (BadgedImageView) findViewById(R.id.badge_4);
    }

    private void touchBadges() {
        badgedIv1.setImageDrawable(getResources().getDrawable(R.drawable.youtube));
        badgedIv1.setBadge("YouTube", Color.WHITE);
        badgedIv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLink("https://www.youtube.com/watch?v=itInMEcvjYc");
            }
        });

        badgedIv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLink("https://plus.google.com/+KirillGrouchnikov/posts/aS22iAz8pnT");
            }
        });

        badgedIv3.setBadge("Google Play");
        badgedIv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLink("http://talon.klinkerapps.com");
            }
        });

        badgedIv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLink("https://github.com/klinker24/Android-BadgedImageView/");
            }
        });
    }

    private void openLink(String link) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_recycler:
                startActivity(new Intent(this, RecyclerActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
