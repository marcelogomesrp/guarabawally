package br.com.guaraba.wally.android.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class PontoOverlay extends Overlay {

	private Paint paint = new Paint();
	
	private final int imageId;
	
	private final GeoPoint geoPoint;

	public PontoOverlay(final GeoPoint geoPoint, final int imageId) {

		this.geoPoint = geoPoint;
		this.imageId = imageId;
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {

		super.draw(canvas, mapView, shadow);

		//converte as coordenadas para pixel
		final Point p = mapView.getProjection().toPixels(this.geoPoint, null);

		final Bitmap bitmap = BitmapFactory.decodeResource(mapView.getResources(), this.imageId);

		final RectF r = new RectF(p.x, p.y, p.x+bitmap.getWidth(), p.y+bitmap.getHeight());

		canvas.drawBitmap(bitmap, null, r, paint);
	}
}