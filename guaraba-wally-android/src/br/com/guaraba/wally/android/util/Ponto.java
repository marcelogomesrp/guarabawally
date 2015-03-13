package br.com.guaraba.wally.android.util;

import android.location.Location;

import com.google.android.maps.GeoPoint;

public final class Ponto extends GeoPoint {

	public Ponto(final int latitudeE6, final int longitudeE6) {

		super(latitudeE6, longitudeE6);
	}

	public Ponto(final double latitude, final double longitude) {

		this((int)(latitude*1E6), (int)(longitude*1E6));
	}

	public Ponto(final Location location) {

		this(location.getLatitude(), location.getLongitude());
	}
}