package com.picturefactory;

/**
 * WelcomeScreen��������ͼƬħ��ʦandroid�ֻ�Ӧ������Ŀ�ʼ����.
 * ������������ͼƬħ��ʦ�ֻ�Ӧ������Ļ�ӭ����.
 * ��ӭ������,�û���ѡ��ʼʹ�����,���߲鿴�������ͼƬ����Ч��ʾ��.
 * ���б���ͼ��������ť��ʵ����������.
 * ��Ӧ�Ĳ����ļ���:welcome_screen_layout.xml
 * 
 * This class is originally created by Zhou Xingyue.
 * 
 * Date: 2010/12/5
 * @author Zhou Xingyue
 *
 */



import net.youmi.android.AdManager;
import net.youmi.android.AdView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class WelcomeScreen extends Activity{
	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		AdManager.init(this,"19703735e4b2f648", "117295b933868f90", 30,  false);
		setContentView(R.layout.welcome_screen_layout);//set the first view to welcome the user
		LinearLayout adViewLayout = (LinearLayout) findViewById(R.id.adViewLayout);
		adViewLayout.addView(new AdView(this), 
		        new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		//Create a start button to enter the application
		Button startButton =(Button) this.findViewById(R.id.start_button);
		startButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						WelcomeScreen.this,
						ChoosePicture.class);

				startActivity(i);
				Log.d("ZhouXingyue","activity2 started");

			}
		});

		//Create a demo button to see sample
		Button demoButton =(Button) this.findViewById(R.id.demo_button);
		demoButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						WelcomeScreen.this,
						ImageProcess.class);

				startActivity(i);
				
			}
		});
		
//		Button portConfigButton =(Button) this.findViewById(R.id.port_config_button);
//		portConfigButton.setOnClickListener(new OnClickListener(){
//			//By pressing the button on this screen, user can go to the second screen to input data.
//			@Override
////			public void onClick(View arg0){
////				Intent i = new Intent(
////						WelcomeScreen.this,
////						PortConfig.class);
////
////				startActivity(i);
////
////			}
//		});







	}
}
