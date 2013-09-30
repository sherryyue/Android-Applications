/**
 * AddIcion类为用户列出了添加的装饰图案.
 * 本类通过BasicFunctionList类中的“添加图案”选项点击调用
 * 对应的布局文件名:add_icon_layout.xml
 * 通过选择相应图案,用户可实现在图片上添加该图案
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


public class AddIcon extends Activity{
	@Override  
	public void onCreate(Bundle savedInstanceState) {   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.add_icon_layout);  
		Button icon1 = (Button) this.findViewById(R.id.icon1);
		// set image button with pre-defined icons as background
		icon1.setBackgroundResource(R.drawable.icon_heart);
		icon1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0){

				Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
				Drawable icon = getResources().getDrawable(R.drawable.icon_heart);//The icon that user chosen to add
				Bitmap bitmapIcon = ImageProcessFunction.drawableToBitmap(icon);//First change the icon to bitmap before editing
				Bitmap addIconBitmap = ImageProcessFunction.addIcon(bitmapOriginal, bitmapIcon);
				ShowResult.modifiedBitmap = addIconBitmap;
				Intent i = new Intent(
						AddIcon.this,
						ShowResult.class);

				startActivity(i);

			}   
		});



		Button icon2 = (Button) this.findViewById(R.id.icon2);
		// set image button with pre-defined icons as background
		icon2.setBackgroundResource(R.drawable.icon_moon);
		icon2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0){

				Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
				Drawable icon = getResources().getDrawable(R.drawable.icon_moon);//The icon that user chosen to add
				Bitmap bitmapIcon = ImageProcessFunction.drawableToBitmap(icon);//First change the icon to bitmap before editing
				Bitmap addIconBitmap = ImageProcessFunction.addIcon(bitmapOriginal, bitmapIcon);
				ShowResult.modifiedBitmap = addIconBitmap;
				Intent i = new Intent(
						AddIcon.this,
						ShowResult.class);

				startActivity(i);

			}   
		});



		Button icon3 = (Button) this.findViewById(R.id.icon3);
		// set image button with pre-defined icons as background
		icon3.setBackgroundResource(R.drawable.icon_star);
		icon3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0){

				Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
				Drawable icon = getResources().getDrawable(R.drawable.icon_star);//The icon that user chosen to add
				Bitmap bitmapIcon = ImageProcessFunction.drawableToBitmap(icon);//First change the icon to bitmap before editing
				Bitmap addIconBitmap = ImageProcessFunction.addIcon(bitmapOriginal, bitmapIcon);
				ShowResult.modifiedBitmap = addIconBitmap;
				Intent i = new Intent(
						AddIcon.this,
						ShowResult.class);

				startActivity(i);

			}   
		});


		Button icon4 = (Button) this.findViewById(R.id.icon4);
		// set image button with pre-defined icons as background
		icon4.setBackgroundResource(R.drawable.icon_rose);
		icon4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0){

				Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
				Drawable icon = getResources().getDrawable(R.drawable.icon_rose);//The icon that user chosen to add
				Bitmap bitmapIcon = ImageProcessFunction.drawableToBitmap(icon);//First change the icon to bitmap before editing
				Bitmap addIconBitmap = ImageProcessFunction.addIcon(bitmapOriginal, bitmapIcon);
				ShowResult.modifiedBitmap = addIconBitmap;
				Intent i = new Intent(
						AddIcon.this,
						ShowResult.class);

				startActivity(i);

			}   
		});


		Button icon5 = (Button) this.findViewById(R.id.icon5);
		// set image button with pre-defined icons as background
		icon5.setBackgroundResource(R.drawable.icon_sun);
		icon5.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0){

				Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
				Drawable icon = getResources().getDrawable(R.drawable.icon_sun);//The icon that user chosen to add
				Bitmap bitmapIcon = ImageProcessFunction.drawableToBitmap(icon);//First change the icon to bitmap before editing
				Bitmap addIconBitmap = ImageProcessFunction.addIcon(bitmapOriginal, bitmapIcon);
				ShowResult.modifiedBitmap = addIconBitmap;
				Intent i = new Intent(
						AddIcon.this,
						ShowResult.class);

				startActivity(i);

			}   
		});


		Button icon6 = (Button) this.findViewById(R.id.icon6);
		// set image button with pre-defined icons as background
		icon6.setBackgroundResource(R.drawable.icon_smile);
		icon6.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0){

				Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
				Drawable icon = getResources().getDrawable(R.drawable.icon_smile);//The icon that user chosen to add
				Bitmap bitmapIcon = ImageProcessFunction.drawableToBitmap(icon);//First change the icon to bitmap before editing
				Bitmap addIconBitmap = ImageProcessFunction.addIcon(bitmapOriginal, bitmapIcon);
				ShowResult.modifiedBitmap = addIconBitmap;
				Intent i = new Intent(
						AddIcon.this,
						ShowResult.class);

				startActivity(i);

			}   
		});


		//Create a button to go back to the previous view
		Button backButton =(Button) this.findViewById(R.id.back_button);
		backButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						AddIcon.this,
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
						AddIcon.this,
						WelcomeScreen.class);

				startActivity(i);

			}
		});

	}



}
