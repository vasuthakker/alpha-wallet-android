package io.stormbird.wallet.ui.widget.holder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.stormbird.wallet.R;
import io.stormbird.wallet.ui.widget.entity.WarningData;

/**
 * Created by James on 18/07/2019.
 * Stormbird in Sydney
 */

public class WarningHolder extends BinderViewHolder<WarningData>
{
    public static final int VIEW_TYPE = 1015;
    private final TextView title;
    private final TextView detail;
    private final RelativeLayout layoutBackground;
    private final ImageView menuButton;
    private final Button backupButton;
    private final View popupAnchor;

    @Override
    public void bind(@Nullable WarningData data, @NonNull Bundle addition)
    {

        title.setText(data.title);
        detail.setText(data.detail);
        layoutBackground.setBackgroundColor(data.colour);
        backupButton.setText(data.buttonText);
        backupButton.setBackgroundColor(data.buttonColour);
        backupButton.setOnClickListener(v -> { data.callback.BackupClick(data.address); });
        menuButton.setOnClickListener(v -> {
            showPopup(popupAnchor);
        });
    }
    private void showPopup(View view) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View popupView = inflater.inflate(R.layout.popup_remind_later, null);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);
        popupWindow.showAsDropDown(view, 0, 20);
    }

    public WarningHolder(int res_id, ViewGroup parent)
    {
        super(res_id, parent);
        title = findViewById(R.id.text_title);
        detail = findViewById(R.id.text_detail);
        layoutBackground = findViewById(R.id.layout_backup_text);
        backupButton = findViewById(R.id.button_backup);
        menuButton = findViewById(R.id.btn_menu);
        popupAnchor = findViewById(R.id.popup_anchor);
    }
}
