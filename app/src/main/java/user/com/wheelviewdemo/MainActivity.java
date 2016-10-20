package user.com.wheelviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import user.com.wheelviewdemo.view.LoopView;

public class MainActivity extends AppCompatActivity {
    private LoopView loopView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list=new ArrayList<>();
        for(int i=0;i<20;i++)
            list.add("Item"+(i+1));
        loopView=(LoopView)findViewById(R.id.loopView);
        loopView.setItems(list);
        loopView.setInitPosition(0);
        loopView.setTextSize(30.0f);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        loopView.setViewPadding(dm.widthPixels/2,0,dm.widthPixels/2,0);//设置LoopView的左右宽度，参数分别对应左上右下
        // loopView.setOneTextHeight(30);//设置单个条目的高度
        loopView.setTextColor(R.color.button_material_dark,0xff00ff00);//设置中间条目和外面条目的颜色,值为0表示默认不设置
        loopView.setOnSelectedItemClickListener(new LoopView.SelectedItemClickListener() {
            @Override
            public void onSelectedItemClickListener(int position) {
                Toast.makeText(getApplicationContext(), "您点击了条目" + position, Toast.LENGTH_SHORT).show();//点击选中条目的响应事件

            }
        });

    }
}
