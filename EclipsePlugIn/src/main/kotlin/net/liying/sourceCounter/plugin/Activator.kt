package net.liying.sourceCounter.plugin

import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext

/**
 * The activator class controls the plug-in life cycle
 */
class Activator(): AbstractUIPlugin() {
	companion object {
		// The plug-in ID
		const val PLUGIN_ID = "SourceCounter" //$NON-NLS-1$

		// The shared instance
		private var plugin: Activator? = null

		/**
		 * Returns the shared instance
		 *
		 * @return the shared instance
		 */
		@JvmStatic
		fun getDefault(): Activator? {
			return plugin
		}

		/**
		 * Returns an image descriptor for the image file at the given
		 * plug-in relative path
		 *
		 * @param path the path
		 * @return the image descriptor
		 */
		@JvmStatic
		fun getImageDescriptor(path: String): ImageDescriptor {
			return imageDescriptorFromPlugin(PLUGIN_ID, path)
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	override fun start(context: BundleContext) {
		super.start(context)

		plugin = this
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	override fun stop(context: BundleContext) {
		plugin = null

		super.stop(context)
	}
}
