/**
 * Resize类为用户列出了可选择的缩放效果.
 * 本类通过BasicFunctionList类中的“改变图片大小”选项点击调用
 * 对应的布局文件名:resize_layout.xml
 * 通过选择不同的缩放方式,用户可实现图片大小的放缩.
 * 通过点击后退可以回到上一个画面
 * 通过点击返回可返回首页 
 *
 * The code of this class is originally created by Zhou Xingyue.
 * 
 * Date: 2010/12/5
 * @author Zhou Xingyue
 *
 */
package com.picturefactory;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Resize extends Activity{
	private RadioGroup resizeChoiceGroup;   
	private RadioButton zoomInRadio ;   
	private RadioButton zoomOutRadio;   
	int choice;

	@Override  
	public void onCreate(Bundle savedInstanceState) {   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.resize_layout);  

		resizeChoiceGroup = (RadioGroup)findViewById(R.id.resize_choices);   
		zoomInRadio= (RadioButton)findViewById(R.id.zoom_in); 
		zoomOutRadio = (RadioButton)findViewById(R.id.zoom_out);   


		resizeChoiceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   

			@Override  
			public void onCheckedChanged(RadioGroup group, int checkedId) {   

				if(zoomInRadio.getId() == checkedId){   
					choice=1;


				}   
				else if(zoomOutRadio.getId() == checkedId)   
				{   
					choice=2;
				}  

			}   
		});  



		Button submit = (Button) this.findViewById(R.id.submit);



		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0){

				if(choice==1){

					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);

					Bitmap zoomBitmap = ImageProcessFunction.zoomBitmap(bitmapOriginal, 30, 30);  

					ShowResult.modifiedBitmap = zoomBitmap;
					Intent i = new Intent(
							Resize.this,
							ShowResult.class);

					startActivity(i);
				}else if(choice==2){
					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);

					Bitmap zoomBitmap = ImageProcessFunction.zoomBitmap(bitmapOriginal, 100, 100);  

					ShowResult.modifiedBitmap = zoomBitmap;
					Intent i = new Intent(
							Resize.this,
							ShowResult.class);

					startActivity(i);
				}

			}   
		});
		//Create a button to go back to the previous view
		Button backButton =(Button) this.findViewById(R.id.back_button);
		backButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						Resize.this,
						BasicFunctionList.class);

				startActivity(i);

			}
		});


		//Create a button to go home view
		Button homeButton =(Button) this.findViewById(R.id.home_button);
		homeButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						Resize.this,
						WelcomeScreen.class);

				startActivity(i);

			}
		});

	}



}

