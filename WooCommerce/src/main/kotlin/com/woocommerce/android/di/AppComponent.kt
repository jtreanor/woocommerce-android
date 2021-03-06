package com.woocommerce.android.di

import android.app.Application
import com.woocommerce.android.WooCommerce
import com.woocommerce.android.push.FCMServiceModule
import com.woocommerce.android.ui.login.LoginAnalyticsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import org.wordpress.android.fluxc.module.ReleaseBaseModule
import org.wordpress.android.fluxc.module.ReleaseNetworkModule
import org.wordpress.android.fluxc.module.ReleaseOkHttpClientModule
import org.wordpress.android.fluxc.module.ReleaseWCNetworkModule
import org.wordpress.android.login.di.LoginServiceModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        AppConfigModule::class,
        ReleaseBaseModule::class,
        ReleaseNetworkModule::class,
        ReleaseWCNetworkModule::class,
        ReleaseOkHttpClientModule::class,
        SelectedSiteModule::class,
        ActivityBindingModule::class,
        FCMServiceModule::class,
        LoginAnalyticsModule::class,
        LoginServiceModule::class,
        NetworkStatusModule::class,
        CurrencyModule::class,
        SupportModule::class])
interface AppComponent : AndroidInjector<WooCommerce> {
    override fun inject(app: WooCommerce)

    // Allows us to inject the application without having to instantiate any modules, and provides the Application
    // in the app graph
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
