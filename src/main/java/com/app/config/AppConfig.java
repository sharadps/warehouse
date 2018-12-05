package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.converter.UserIdToObjectConverter;
import com.app.model.Customer;
import com.app.model.Document;
import com.app.model.Item;
import com.app.model.OrderModel;
import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.model.User;
import com.app.model.Vendor;
import com.app.model.WhUserType;
import com.app.validator.CustomerValidator;
import com.app.validator.ItemValidator;
import com.app.validator.OrderModelValidator;
import com.app.validator.PurchaseOrderValidator;
import com.app.validator.ShipmentTypeValidator;
import com.app.validator.UomValidator;
import com.app.validator.VendorValidator;
import com.app.validator.WhUserTypeValidator;
import com.app.view.CustomerPdfView;
import com.app.view.ItemExcelView;
import com.app.view.ItemPdfView;
import com.app.view.OrderModelExcelView;
import com.app.view.OrderModelPdfView;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;
import com.app.view.VendorExcelView;
import com.app.view.VendorPdfView;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

//ctrl+shift+O (imports)
@Configuration // Java Config File
@EnableWebMvc // make this as web application
@EnableTransactionManagement // enable commit/rollback
@ComponentScan(basePackages = "com.app") // all files are created under this folder only
@PropertySource("classpath:app.properties") // load properties file from src/main/resource folder
public class AppConfig implements WebMvcConfigurer {

	// load properties into AppConfig
	@Autowired
	private Environment env;

	@Autowired
	private UserIdToObjectConverter userIdConverter;

	// 1. DataSource Bean
	@Bean // => @Bean creating Object
	public BasicDataSource dsObj() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("dc"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("un"));
		ds.setPassword(env.getProperty("pwd"));
		ds.setInitialSize(5);
		ds.setMaxIdle(5);
		ds.setMinIdle(3);
		ds.setMaxTotal(5);
		return ds;
	}

	// 2. SessionFactory Bean
	@Bean // => creating Object
	public LocalSessionFactoryBean sfObj() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dsObj());
		sf.setAnnotatedClasses(Vendor.class, VendorExcelView.class, VendorPdfView.class, WhUserType.class,
				WhUserTypeExcelView.class, WhUserTypePdfView.class, Customer.class, CustomerPdfView.class, Uom.class,
				UomPdfView.class, UomExcelView.class, OrderModel.class, OrderModelExcelView.class,
				OrderModelPdfView.class, ShipmentType.class, ShipmentTypeExcelView.class, ShipmentTypePdfView.class,
				Document.class, Item.class, ItemExcelView.class, ItemPdfView.class, UserIdToObjectConverter.class,
				UomValidator.class, CustomerValidator.class, WhUserTypeValidator.class, ShipmentTypeValidator.class,
				OrderModelValidator.class, VendorValidator.class, ItemValidator.class, PurchaseOrder.class,
				PurchaseOrderValidator.class, User.class);

		sf.setHibernateProperties(props());
		return sf;
	}

	/* Hibernate Properties */
	private Properties props() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getProperty("dialect"));
		p.put("hibernate.show_sql", env.getProperty("showsql"));
		p.put("hibernate.format_sql", env.getProperty("fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("ddlauto"));
		return p;
	}

	// 3. HibernateTemplate Bean
	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht = new HibernateTemplate();
		ht.setSessionFactory(sfObj().getObject());
		return ht;
	}

	// 4. HibernateTxManager Bean
	@Bean
	public HibernateTransactionManager htxm() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sfObj().getObject());
		return htm;
	}

	// 5. ViewResolver Bean
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix(env.getProperty("mvc.prefix"));
		vr.setSuffix(env.getProperty("mvc.suffix"));
		return vr;
	}

	// 6.Multipart Resolver
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver r=new CommonsMultipartResolver();
		r.setMaxUploadSize(20971520);
		r.setMaxInMemorySize(20971520);
		//20x1024x1024 = 20 MB
		return r;
	}

	// 7. Password Encoder
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(userIdConverter);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
