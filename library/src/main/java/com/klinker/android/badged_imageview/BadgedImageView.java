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

package com.klinker.android.badged_imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;

public class BadgedImageView extends ImageView {

    private boolean badgeBoundsSet = false;

    private BadgeDrawable badge;
    private int badgeGravity;
    private int badgePadding;
    private int badgeColor;

    public BadgedImageView(Context context) {
        this(context, 0, 0, Color.WHITE);
    }

    public BadgedImageView(Context context, int badgeGravity, int badgePadding, int badgeColor) {
        super(context);

        this.badgeGravity = badgeGravity;
        this.badgePadding = badgePadding;
        this.badgeColor = badgeColor;
    }

    public BadgedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BadgedImageView, 0, 0);
        badgeGravity = a.getInt(R.styleable.BadgedImageView_badgeGravity, Gravity.START | Gravity.BOTTOM);
        badgeColor = a.getColor(R.styleable.BadgedImageView_badgeColor, Color.WHITE);
        badgePadding = a.getDimensionPixelSize(R.styleable.BadgedImageView_badgePadding, 0);
        String badgeText = a.getString(R.styleable.BadgedImageView_badgeText);
        a.recycle();

        if (badgeText != null) {
            setBadge(badgeText);
        }
    }

    public void setBadge(String text) {
        setBadge(text, badgeColor);
    }

    public void setBadge(String text, int color) {
        badge = new BadgeDrawable(getContext(), text);
        badge.setColorFilter(color, PorterDuff.Mode.SRC_IN);

        invalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (badge != null) {
            if (!badgeBoundsSet) {
                layoutBadge();
            }
            badge.draw(canvas);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (badge != null) {
            layoutBadge();
        }
    }

    private void layoutBadge() {
        Rect badgeBounds = badge.getBounds();
        Gravity.apply(badgeGravity,
                badge.getIntrinsicWidth(),
                badge.getIntrinsicHeight(),
                new Rect(0, 0, getWidth(), getHeight()),
                badgePadding,
                badgePadding,
                badgeBounds);
        badge.setBounds(badgeBounds);
        badgeBoundsSet = true;
    }
}
