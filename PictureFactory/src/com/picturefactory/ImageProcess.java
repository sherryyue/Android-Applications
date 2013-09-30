/**
 * ImageProcess类为用户展示本软件所有可实现的图片处理功能的处理示例
 * 设有返回按钮,可通过返回按钮返回上一画面.
 * 本类通过WelcomeScreen类中的“示例”按钮点击调用
 * 对应的布局文件名:image_processing_layout.xml
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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;   
public class ImageProcess extends Activity {   
	private ImageView originalView,sample1,sample2,sample3,sample4,sample5,sample6,sample7,sample8,sample9,sample10;   

	public void onCreate(Bundle savedInstanceState) {   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.image_processing_layout);   
		setupViews();   

		//Create a button to go back to the previous view
		Button backButton =(Button) this.findViewById(R.id.back_button);
		backButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						ImageProcess.this,
						WelcomeScreen.class);

				startActivity(i);

			}
		});



	}   

	private void setupViews(){   
		sample1 = (ImageView)findViewById(R.id.image01);   
		sample2 = (ImageView)findViewById(R.id.image02);
		sample3 = (ImageView)findViewById(R.id.image03);
		sample4 = (ImageView)findViewById(R.id.image04);
		sample5 = (ImageView)findViewById(R.id.image05);
		sample6 = (ImageView)findViewById(R.id.image06);
		sample7 = (ImageView)findViewById(R.id.image07);
		sample8 = (ImageView)findViewById(R.id.sample8);
		sample9 = (ImageView)findViewById(R.id.sample9);
		sample10 = (ImageView)findViewById(R.id.sample10);

		Drawable icon = getResources().getDrawable(R.drawable.icon);//The icon that user chosen to add
		Bitmap bitmapIcon = ImageProcessFunction.drawableToBitmap(icon);//First change the icon to bitmap before editing


		/*
		 * original picture
		 */
		Drawable drawableRes = getResources().getDrawable(R.drawable.sample);
		//change Drawable to Bitmap   
		Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(drawableRes);
		//Firstly, zoom in the original picture
		bitmapOriginal = ImageProcessFunction.zoomBitmap(bitmapOriginal,300, 240);
		//Add icon to original sample
		Bitmap addIconBitmap = ImageProcessFunction.addIcon(bitmapOriginal, bitmapIcon);

		/*
		 * samples of basic functions
		 */
		//horizontal flip sample
		Bitmap horizontalFlipBitmap = ImageProcessFunction.horizontalFlip(bitmapOriginal);
		//distort sample
		Bitmap distortBitmap = ImageProcessFunction.distort(bitmapOriginal,0.2f,0.2f);
		//zoom sample
		Bitmap zoomBitmap = ImageProcessFunction.zoomBitmap(bitmapOriginal, 30, 30);   
		//get prune sample
		Bitmap roundBitmap = ImageProcessFunction.getRoundedCornerBitmap(bitmapOriginal, 100.0f,70.0f);   
		// reflection sample
		Bitmap reflectBitmap = ImageProcessFunction.createReflectionImageWithOrigin(bitmapOriginal);   

		/*
		 * samples of advanced functions
		 */
		//transparency gradient sample
		Drawable demo8 = getResources().getDrawable(R.drawable.sample8);
		Bitmap bitmapDemo8 = ImageProcessFunction.drawableToBitmap(demo8);
		bitmapDemo8 = ImageProcessFunction.zoomBitmap(bitmapDemo8,300, 240);
		//transparency sample
		Drawable demo9 = getResources().getDrawable(R.drawable.sample9);
		Bitmap bitmapDemo9 = ImageProcessFunction.drawableToBitmap(demo9);
		bitmapDemo9 = ImageProcessFunction.zoomBitmap(bitmapDemo9,300, 240);
		//tint sample
		Drawable demo10 = getResources().getDrawable(R.drawable.sample10);
		Bitmap bitmapDemo10 = ImageProcessFunction.drawableToBitmap(demo10);
		bitmapDemo10 = ImageProcessFunction.zoomBitmap(bitmapDemo10,300, 240);




		sample1.setImageBitmap(bitmapOriginal); 
		sample2.setImageBitmap(addIconBitmap); 
		sample3.setImageBitmap(zoomBitmap);
		sample4.setImageBitmap(reflectBitmap);  
		sample5.setImageBitmap(distortBitmap); 
		sample6.setImageBitmap(roundBitmap);  
		sample7.setImageBitmap(horizontalFlipBitmap);
		sample8.setImageBitmap(bitmapDemo8); 
		sample9.setImageBitmap(bitmapDemo9);  
		sample10.setImageBitmap(bitmapDemo10);
	}   


}  


