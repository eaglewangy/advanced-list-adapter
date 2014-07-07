package com.example.bindableadaptertest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.peony.listadapter.BindDictionary;
import com.peony.listadapter.ListAdapter;
import com.peony.listadapter.extractors.StringExtractor;
import com.peony.listadapter.interfaces.DynamicImageLoader;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Product> prodList = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            Product product = new Product();
            product.title = "Title" + i;
            product.description = "description " + i;
            product.price = 20 + i;
            prodList.add(product);
        }
        // Show our data
        initFunDapter(prodList);
    }

    private void initViews() {
        list = (ListView) findViewById(R.id.pager);
    }

    /**
     * This is where we create the adapter. Instead of writing a whole class for
     * it we simply define which fields we are going to fill with data.
     *
     * @param prodList
     */
    public void initFunDapter(ArrayList<Product> prodList) {

        BindDictionary<Product> prodDict = buildDictionary();

        // Create our adapter giving it a product list, resource to inflate and
        // dictionary
        ListAdapter<Product> adapter = new ListAdapter<>(this, prodList, R.layout.product_list_item, prodDict);
        list.setAdapter(adapter);
    }

    public static BindDictionary<Product> buildDictionary() {
        // create the binding dictionary
        BindDictionary<Product> prodDict = new BindDictionary<Product>();
        prodDict.addStringField(R.id.title, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product item, int position) {
                return item.title;
            }
        }).visibilityIfNull(View.GONE);
        prodDict.addStringField(R.id.description, new StringExtractor<Product>() {

            @Override
            public String getStringValue(Product item, int position) {
                return item.description;
            }
        });
        prodDict.addStringField(R.id.price, new StringExtractor<Product>() {

            @Override
            public String getStringValue(Product item, int position) {
                return item.price + " $";
            }
        }).background(new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product item, int position) {
                return "#00ff00";
            }
        });
        prodDict.addDynamicImageField(R.id.image, new StringExtractor<Product>() {

                    @Override
                    public String getStringValue(Product item, int position) {
                        return item.imageUrl;
                    }
                }, new DynamicImageLoader() {
                    @Override
                    public void loadImage(String url, ImageView view) {
                        // INSERT IMAGE LOADER LIBRARY HERE
                    }
                }
        );
        return prodDict;
    }
}
