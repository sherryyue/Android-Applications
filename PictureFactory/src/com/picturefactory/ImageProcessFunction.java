/**
 * ImageProcessFunction类中定义了所有基本处理功能的方法,分别被如下类调用：AddIcon,Distort,Prune,Reflection,Resize.
 * 除此以外，本类还定义了用于图片类型转换的方法.
 * 无对应的布局文件.
 * 
 * 
 * Acknowledgement:
 * The algorithm of basic functions is modified from: http://www.javaeye.com/problems/48151,
 * which are also clearly marked in each corresponding parts.
 * Other parts of this code is also marked if they are referred to other resources.
 * The rest part of the part is originally created by Zhou Xingyue, if no statement declared.
 * 
 * Date: 2010/12/5
 * @author Zhou Xingyue
 *
 */

package com.picturefactory;

import android.graphics.Bitmap;   
import android.graphics.Canvas;   
import android.graphics.LinearGradient;   
import android.graphics.Matrix;   
import android.graphics.Paint;   
import android.graphics.PixelFormat;   
import android.graphics.PorterDuffXfermode;   
import android.graphics.Rect;   
import android.graphics.RectF;   
import android.graphics.Bitmap.Config;   
import android.graphics.PorterDuff.Mode;   
import android.graphics.Shader.TileMode;   
import android.graphics.drawable.Drawable;   
public class ImageProcessFunction {  

	/**
	 * Code for horizontally flipping the picture
	 * Reference: originally created
	 */

	public static Bitmap horizontalFlip(Bitmap originalBitmap){
		Matrix temp = new Matrix();
		Matrix horizontalFlipMatrix = new Matrix();
		float[] horizontalFlip = {   
				-1, 0, 0,   
				0, 1, 0,   
				0, 0, 1   
		};   

		temp.setValues(horizontalFlip);   

		horizontalFlipMatrix.postConcat(temp);   

		int width = originalBitmap.getWidth();
		int height = originalBitmap.getHeight();

		Bitmap horizontalFlipImage = Bitmap.createBitmap(originalBitmap, 0, 0, width, height, horizontalFlipMatrix, true);
		return horizontalFlipImage;
	}

	/**
	 * Code for vertically fliping the picture
	 * Reference: originally created
	 */

	public static Bitmap verticalFlip(Bitmap originalBitmap){
		Matrix temp = new Matrix();
		Matrix verticalFlipMatrix = new Matrix();
		float[] verticalFlip = {   
				1, 0, 0,   
				0, -1, 0,   
				0, 0, 1   
		};   

		temp.setValues(verticalFlip);   

		verticalFlipMatrix.postConcat(temp);   

		int width = originalBitmap.getWidth();
		int height = originalBitmap.getHeight();

		Bitmap verticalFlipImage = Bitmap.createBitmap(originalBitmap, 0, 0, width, height, verticalFlipMatrix, true);
		return verticalFlipImage;
	}

	/**
	 * Code for distorting the picture
	 * Reference: originally created
	 */
	public static Bitmap distort(Bitmap originalBitmap,float x, float y){

		Matrix distortMatrix = new Matrix();
		distortMatrix.postSkew(x, y,0, 0);

		int width = originalBitmap.getWidth();
		int height = originalBitmap.getHeight();

		Bitmap distortImage = Bitmap.createBitmap(originalBitmap, 0, 0, width, height, distortMatrix, true);
		return distortImage;
	}



	/**
	 * Code of add icon function
	 * Reference:this method is modified from http://www.javaeye.com/problems/48151 
	 */

	public static  Bitmap addIcon( Bitmap mainImage, Bitmap icon ){
		int mainWidth = mainImage.getWidth();   
		int mainHeight = mainImage.getHeight();   
		int iconWidth = icon.getWidth();   
		int iconHeight = icon.getHeight();   
		Bitmap imageWithIcon = Bitmap.createBitmap( mainWidth, mainHeight, Config.ARGB_8888 );//
		Canvas canvasWithIcon = new Canvas( imageWithIcon );   
		canvasWithIcon.drawBitmap( mainImage, 0, 0, null );//
		canvasWithIcon.drawBitmap( icon, mainWidth - iconWidth + 5, mainHeight - iconHeight  + 5, null );//
		canvasWithIcon.save( Canvas.ALL_SAVE_FLAG );//
		canvasWithIcon.restore();//
		return imageWithIcon;
	}





	/**
	 * Code of resize function
	 * Reference:this method is modified from http://www.javaeye.com/problems/48151 
	 */
	public static Bitmap zoomBitmap(Bitmap bitmap,int w,int h){   
		int width = bitmap.getWidth();   
		int height = bitmap.getHeight();   
		Matrix matrix = new Matrix();   
		float scaleWidht = ((float)w / width);   
		float scaleHeight = ((float)h / height);   
		matrix.postScale(scaleWidht, scaleHeight);   
		Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);   
		return newbmp;   
	}   

	/**
	 * Code of change drawable to bitmap
	 * Reference:this method is modified from http://www.javaeye.com/problems/48151 
	 */
	public static Bitmap drawableToBitmap(Drawable drawable){   
		int width = drawable.getIntrinsicWidth();   
		int height = drawable.getIntrinsicHeight();   
		Bitmap bitmap = Bitmap.createBitmap(width, height,   
				drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888   
						: Bitmap.Config.RGB_565);   
		Canvas canvas = new Canvas(bitmap);   
		drawable.setBounds(0,0,width,height);   
		drawable.draw(canvas);   
		return bitmap;   

	}   

	/**
	 * Code of prune function
	 * Reference:this method is modified from http://www.javaeye.com/problems/48151 
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap,float roundPx,float roundPy){   

		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap   
				.getHeight(), Config.ARGB_8888);   
		Canvas canvas = new Canvas(output);   

		final int color = 0xff424242;   
		final Paint paint = new Paint();   
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());   
		final RectF rectF = new RectF(rect);   

		paint.setAntiAlias(true);   
		canvas.drawARGB(0, 0, 0, 0);   
		paint.setColor(color);   
		canvas.drawRoundRect(rectF, roundPx, roundPy, paint);   

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));   
		canvas.drawBitmap(bitmap, rect, rect, paint);   

		return output;   
	}   


	/**
	 * Code of reflection function
	 * Reference:this method is modified from http://www.javaeye.com/problems/48151 
	 */
	public static Bitmap createReflectionImageWithOrigin(Bitmap bitmap){   
		final int reflectionGap = 4;   
		int width = bitmap.getWidth();   
		int height = bitmap.getHeight();   

		Matrix matrix = new Matrix();   
		matrix.preScale(1, -1);   

		Bitmap reflectionImage = Bitmap.createBitmap(bitmap,    
				0, height/2, width, height/2, matrix, false);   

		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, (height + height/2), Config.ARGB_8888);   

		Canvas canvas = new Canvas(bitmapWithReflection);   
		canvas.drawBitmap(bitmap, 0, 0, null);   
		Paint deafalutPaint = new Paint();   
		canvas.drawRect(0, height,width,height + reflectionGap,   
				deafalutPaint);   

		canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);   

		Paint paint = new Paint();   
		LinearGradient shader = new LinearGradient(0,   
				bitmap.getHeight(), 0, bitmapWithReflection.getHeight()   
				+ reflectionGap, 0x70ffffff, 0x00ffffff, TileMode.CLAMP);   
		paint.setShader(shader);   
		// Set the Transfer mode to be porter duff and destination in   
		paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));   
		// Draw a rectangle using the paint with our linear gradient   
		canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()   
				+ reflectionGap, paint);   

		return bitmapWithReflection;   
	}   

}  
