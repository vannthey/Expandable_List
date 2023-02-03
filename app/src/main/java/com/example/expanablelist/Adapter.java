package com.example.expanablelist;

import android.animation.LayoutTransition;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<Model> modelList;
    Context context;

    public Adapter(Context context, List<Model> modelList) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent,false);
        TextView title, subtitle;
        LinearLayout item_layout;
        CardView item_card;

        item_layout = convertView.findViewById(R.id.item_layout);
        item_card = convertView.findViewById(R.id.item_card);
        title = convertView.findViewById(R.id.txtTitle);
        subtitle = convertView.findViewById(R.id.txtSubtitle);

        Model currentItem = (Model) getItem(position);

        title.setText(currentItem.getTitle());
        subtitle.setText(currentItem.getSubtitle());

        item_layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        item_card.setOnClickListener(l -> {
            int section = (subtitle.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
            TransitionManager.beginDelayedTransition(item_layout, new AutoTransition());
            subtitle.setVisibility(section);
        });

        return convertView;
    }
}
