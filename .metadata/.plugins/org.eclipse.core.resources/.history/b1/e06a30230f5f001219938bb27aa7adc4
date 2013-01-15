package org.example.wallpaper;

import android.service.wallpaper.WallpaperService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

public class Wallpaper extends WallpaperService {
	
	private class MyEngine extends Engine {
		private GLRenderer glRenderer;
		private GL10 gl;
		private EGL10 egl;
		private EGLContext glc;
		private EGLDisplay glDisplay;
		private EGLSurface glSurface;
		
		private ExecutorService executor;
		private Runnable drawCommand;
		
		@Override
		public void onCreate(final SurfaceHolder holder) {
			super.onCreate(holder);
			executor = Executors.newSingleThreadExecutor();
			
			drawCommand = new Runnable() {
				public void run() {
					glRenderer.onDrawFrame(gl);
					egl.eglSwapBuffers(glDisplay, glSurface);
					if (isVisible()
							&& egl.eglGetError() != EGL11.EGL_CONTEXT_LOST
							&& !executor.isShutdown()) {
						executor.execute(drawCommand);
					}
				}
			};
		}
		
		@Override
		public void onDestroy() {
			executor.shutdown();
			super.onDestroy();
		}
		
		@Override
		public void onSurfaceCreated(final SurfaceHolder holder) {
			super.onSurfaceCreated(holder);
		}
		
		@Override
		public void onSurfaceDestroyed(final SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
		}
		
		@Override
		public void onSurfaceChanged(final SurfaceHolder holder,
		final int format, final int width, final int height) {
			super.onSurfaceChanged(holder, format, width, height);
		}
		
		@Override
		public void onVisibilityChanged(final boolean visible) {
			super.onVisibilityChanged(visible);
		}
		
		@Override
		public void onOffsetsChanged(final float xOffset,
			final float yOffset, final float xOffsetStep,
			final float yOffsetStep, final int xPixelOffset,
			final int yPixelOffset) {
				super.onOffsetsChanged(xOffset, yOffset, xOffsetStep,
				yOffsetStep, xPixelOffset, yPixelOffset);
			}
		}

	@Override
	public Engine onCreateEngine() {
		// TODO Auto-generated method stub
		return null;
	}


}
