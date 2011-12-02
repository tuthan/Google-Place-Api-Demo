package hung.vo.hung.vo;

import hung.vo.PlaceRequest;
import hung.vo.R;
import hung.vo.R.layout;
import hung.vo.model.Place;
import hung.vo.model.PlacesList;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GooglePlaceActivity extends Activity {
    /** Called when the activity is first created. */
	Button btn1;
	TextView txt1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn1 = (Button)findViewById(R.id.button1);
        txt1 = (TextView)findViewById(R.id.textView1);
        btn1.setOnClickListener(l);        
		
    }
    
    View.OnClickListener l = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			PlacesList pl = null;
			String text = "Result \n";
			try {
				 pl = new PlaceRequest().performSearch();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			if (pl!=null){
				for(Place place: pl.results){
					text = text + place.name +"\n";
				}
				txt1.setText(text);
			}
			
		}
	};
}