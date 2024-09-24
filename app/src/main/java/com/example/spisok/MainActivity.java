package com.example.spisok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // определяем слушателя нажатия элемента в списке
        StateAdapter.OnStateClickListener stateClickListener = new StateAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(State state, int position) {

                Toast.makeText(getApplicationContext(), "Был выбран пункт " + state.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, states, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        states.add(new State("Щвейцарский поход Суворова", "Суриков", R.drawable.Ones));
        states.add(new State("Девочка с сережками", "Ван Гог", R.drawable.Twos));
        states.add(new State("Явление Христа народу", "Васнецов", R.drawable.Threes));
        states.add(new State("Ночная Гавань", "Айвазовский", R.drawable.Fours));
        states.add(new State("Адам", "Микилянджело", R.drawable.Fives));
        states.add(new State("Закат", "Айвазовский", R.drawable.Sixs));
    }
}