package tiger.com.slidefragmentdemo.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.socks.library.KLog;
import butterknife.ButterKnife;
import tiger.com.slidefragmentdemo.R;

/**
 * @author fml
 * created at 2016/6/20 13:41
 * description：LazyFragment使用懒加载方法，避免切换fragment的时候造成其它fragment onstart方法运行,lazyLoad方法代替onstart方法
 */
public class FiveFragment extends LazyFragment{
    // 标志fragment是否初始化完成
    private boolean isPrepared;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_five , container , false);
            ButterKnife.inject(this, view);
            KLog.e("TAG" , "fiveFragment--onCreateView");
            isPrepared = true;
            lazyLoad();
        }
        return view;
    }


    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
        KLog.e("TAG" , "fiveFragment--lazyLoad");
    }
}
