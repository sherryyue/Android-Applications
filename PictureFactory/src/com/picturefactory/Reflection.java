/**
 * Reflection类为用户列出了可选择的创建镜像效果.
 * 本类通过BasicFunctionList类中的“创建镜像效果”选项点击调用
 * 对应的布局文件名:reflection_layout.xml
 * 通过选择不同的创建镜像效果,用户可实现在图片上创建镜像效果.
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

public class Reflection extends Activity{
	private RadioGroup reflectionChoiceGroup;   
	private RadioButton reflectionRadio ;   
	private RadioButton horizontalFlipRadio;   
	private RadioButton verticallyFlipRadio;   
	int choice;

	@Override  
	public void onCreate(Bundle savedInstanceState) {   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.reflection_layout);  

		reflectionChoiceGroup = (RadioGroup)findViewById(R.id.reflection_choices);   
		reflectionRadio= (RadioButton)findViewById(R.id.reflection); 
		horizontalFlipRadio = (RadioButton)findViewById(R.id.horizontal_flip);
		verticallyFlipRadio= (RadioButton)findViewById(R.id.vertical_flip);

		reflectionChoiceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   

			@Override  
			public void onCheckedChanged(RadioGroup group, int checkedId) {   

				if(reflectionRadio.getId() == checkedId){   
					choice=1;


				}   
				else if(horizontalFlipRadio.getId() == checkedId)   
				{   
					choice=2;
				}  
				else if(verticallyFlipRadio.getId() == checkedId)   
				{   
					choice=3;
				}  
			}   
		});  



		Button submit = (Button) this.findViewById(R.id.submit);



		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0){

				if(choice==1){

					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);

					Bitmap reflectBitmap = ImageProcessFunction.createReflectionImageWithOrigin(bitmapOriginal);   

					ShowResult.modifiedBitmap = reflectBitmap;
					Intent i = new Intent(
							Reflection.this,
							ShowResult.class);

					startActivity(i);
				}else if(choice==2){
					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);

					Bitmap horizontalFlipBitmap = ImageProcessFunction.horizontalFlip(bitmapOriginal);  

					ShowResult.modifiedBitmap = horizontalFlipBitmap;
					Intent i = new Intent(
							Reflection.this,
							ShowResult.class);

					startActivity(i);
				}else if(choice==3){
					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);

					Bitmap verticalFlipBitmap = ImageProcessFunction.verticalFlip(bitmapOriginal);  

					ShowResult.modifiedBitmap = verticalFlipBitmap ;
					Intent i = new Intent(
							Reflection.this,
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
						Reflection.this,
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
						Reflection.this,
						WelcomeScreen.class);

				startActivity(i);

			}
		});


	}



}

