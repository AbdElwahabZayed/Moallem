package com.task.moallem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.task.moallem.R;
import com.task.moallem.model.Subject;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.AdapterHolder> {

    private final Context context;
    private List<Subject> subjectList;

    public SubjectAdapter(Context context) {
        this.context=context;
    }

    public void setAdapterData(List<Subject> subjectList){
        this.subjectList=subjectList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterHolder myHolder=new AdapterHolder(LayoutInflater.from(context).inflate(R.layout.item_subject, parent, false));

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        Subject subject=subjectList.get(position);
        holder.name.setText(subject.getName());
        System.out.println("subject.getImage() "+subject.getImage());
        holder.imageView.setImageResource(subject.getImage());
    }

    @Override
    public int getItemCount() {
        return subjectList!=null?subjectList.size():0;
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView_subject);
            name= itemView.findViewById(R.id.txtview_subject_name);
        }
    }
}
