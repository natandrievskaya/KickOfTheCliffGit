package com.example.natan.kickofthecliff.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.natan.kickofthecliff.R;
import com.example.natan.kickofthecliff.dto.KickDTO;

import java.util.List;

public class KickListAdapter extends RecyclerView.Adapter<KickListAdapter.KickViewHolder> {

    private List<KickDTO> data;

    public KickListAdapter(List<KickDTO> data) {//конструктор для получения данных
        this.data = data;
    }

    @Override
    public KickViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//создание карточек
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kick_item, parent, false);

        return new KickViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KickViewHolder holder, int position) {//передача данных в карточки
        holder.title.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {//количество айтемов (карточек)
        return data.size();
    }

    public static class KickViewHolder extends RecyclerView.ViewHolder {//поиск карточек по Id

        CardView cardView;
        TextView title;

        public KickViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public void setData(List<KickDTO> data) {//сеттер данных
        this.data = data;
    }
}
