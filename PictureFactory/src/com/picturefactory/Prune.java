/**
 * Prune类为用户列出了可选择的剪裁样式.
 * 本类通过BasicFunctionList类中的“图片修剪”选项点击调用
 * 对应的布局文件名:prune_layout.xml
 * 通过选择不同的修剪方式,用户可实现在图片的剪裁
 * 通过点击后退可以回到上一个画面
 * 通过点击返回可返回首页 
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

public class Prune extends Activity{
	private RadioGroup pruneChoicesGroup;   
	private RadioButton roundRectangular ;   
	private RadioButton oval;   
	private RadioButton cylinder;   
	int choice;
	float radiusX,radiusY;

	@Override  
	public void onCreate(Bundle savedInstanceState) {   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.prune_layout);  

		pruneChoicesGroup = (RadioGroup)findViewById(R.id.prune_choices);   
		roundRectangular= (RadioButton)findViewById(R.id.round_rectangular); 
		oval = (RadioButton)findViewById(R.id.oval);
		cylinder= (RadioButton)findViewById(R.id.cylinder);

		pruneChoicesGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   

			@Override  
			public void onCheckedChanged(RadioGroup group, int checkedId) {   

				if(roundRectangular.getId() == checkedId){   
					choice=1;
					radiusX=75.0f;
					radiusY=50.0f;

				}   
				else if(oval.getId() == checkedId)   
				{   
					choice=2;
					if( ChoosePicture.chosenPictureHeight >= ChoosePicture.chosenPictureWidth){
						radiusX=ChoosePicture.chosenPictureHeight;
						radiusY=ChoosePicture.chosenPictureHeight;
					}else {
						radiusX=ChoosePicture.chosenPictureWidth;
						radiusY=ChoosePicture.chosenPictureWidth;
					}

				}  
				else if(cylinder.getId() == checkedId)   
				{   
					choice=3;

					radiusX=ChoosePicture.chosenPictureWidth/2;
					radiusY=ChoosePicture.chosenPictureHeight/2;
				}  
			}   
		});  



		Button submit = (Button) this.findViewById(R.id.submit);



		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0){

				if(choice==1){

					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
					Bitmap roundBitmap = ImageProcessFunction.getRoundedCornerBitmap(bitmapOriginal, radiusX,radiusY); 


					ShowResult.modifiedBitmap = roundBitmap;
					Intent i = new Intent(
							Prune.this,
							ShowResult.class);

					startActivity(i);
				}else if(choice==2){
					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);

					Bitmap roundBitmap = ImageProcessFunction.getRoundedCornerBitmap(bitmapOriginal, radiusX,radiusY); 


					ShowResult.modifiedBitmap = roundBitmap;


					Intent i = new Intent(
							Prune.this,
							ShowResult.class);

					startActivity(i);
				}else if(choice==3){
					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);

					Bitmap roundBitmap = ImageProcessFunction.getRoundedCornerBitmap(bitmapOriginal, radiusX,radiusY); 


					ShowResult.modifiedBitmap = roundBitmap;
					Intent i = new Intent(
							Prune.this,
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
						Prune.this,
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
						Prune.this,
						WelcomeScreen.class);

				startActivity(i);

			}
		});


	}



}

