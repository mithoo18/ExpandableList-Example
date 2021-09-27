package com.example.expandablelist_example;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomizedExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableTitleList;
    private HashMap<String,List<String>> expandableDetailList;

    public CustomizedExpandableListAdapter(Context context, List<String> expandableTitleList, HashMap<String, List<String>> expandableDetailList) {
        this.context = context;
        this.expandableTitleList = expandableTitleList;
        this.expandableDetailList = expandableDetailList;
    }

    // Gets the number of groups.
    @Override
    public int getGroupCount() {
        return this.expandableTitleList.size();
    }

    // Gets the number of children in a specified group.
    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableDetailList.get(this.expandableTitleList.get(listPosition)).size();
    }

    // Gets the data associated with the given group.
    @Override
    public Object getGroup(int listPosition) {
        return this.expandableTitleList.get(listPosition);
    }

    // Gets the data associated with the given child within the given group.
    @Override
    public Object getChild(int lstPosn, int expanded_ListPosition) {
        return this.expandableDetailList.get(this.expandableTitleList.get(lstPosn)).get(expanded_ListPosition);
    }

    // Gets the ID for the group at the given position. This group ID must be unique across groups.
    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    // Gets the ID for the given child within the given group.
    // This ID must be unique across all children within the group. Hence we can pick the child uniquely
    @Override
    public long getChildId(int listPosition, int expanded_ListPosition) {
        return expanded_ListPosition;
    }

    // Indicates whether the child and group IDs are stable across changes to the underlying data.
    @Override
    public boolean hasStableIds() {
        return false;
    }

    // Gets a View that displays the given group.
    // This View is only for the group--the Views for the group's children
    // will be fetched using getChildView()
    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    // Gets a View that displays the data for the given child within the given group.
    @Override
    public View getChildView(int lstPosn, final int expanded_ListPosition,boolean isLastChild, View convertView, ViewGroup parent) {

        final String expandedListText = (String) getChild(lstPosn, expanded_ListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    // Whether the child at the specified position is selectable.
    @Override
    public boolean isChildSelectable(int listPosition, int expanded_ListPosition) {
        return true;
    }
}
