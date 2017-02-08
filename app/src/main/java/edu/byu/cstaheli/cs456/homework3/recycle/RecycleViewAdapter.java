package edu.byu.cstaheli.cs456.homework3.recycle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.byu.cstaheli.cs456.homework3.R;

/**
 * Created by cstaheli on 2/7/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>
{
    private String[] dataset;

    public RecycleViewAdapter(String[] dataset)
    {
        this.dataset = dataset;
    }

    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        TextView view = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.ViewHolder holder, int position)
    {
        holder.mTextView.setText(dataset[position]);
    }

    @Override
    public int getItemCount()
    {
        return dataset.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        // each data item is just a string in this case
        public TextView mTextView;

        public ViewHolder(TextView v)
        {
            super(v);
            mTextView = v;
        }
    }
}
