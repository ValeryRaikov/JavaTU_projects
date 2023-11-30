import java.util.ArrayList;
import java.util.stream.Collectors;

public class PresentStore {
    private ArrayList<GetProductsTo> products;
    private ArrayList<DeliveryAPI> devApi;

    public PresentStore() {
        products = new ArrayList<>();
        devApi = new ArrayList<>();
    }

    public void addProduct(GetProductsTo product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    public void addDevAPI(DeliveryAPI api) {
        if (api == null) {
            throw new IllegalArgumentException("Delivery API cannot be null");
        }
        devApi.add(api);
    }

    public ArrayList<GetProductsTo> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<GetProductsTo> products) {
        if (products == null) {
            throw new IllegalArgumentException("Products list cannot be null");
        }

        this.products = products;
    }

    public ArrayList<DeliveryAPI> getDevApi() {
        return devApi;
    }

    public void setDevApi(ArrayList<DeliveryAPI> devApi) {
        if (devApi == null) {
            throw new IllegalArgumentException("Delivery API list cannot be null");
        }

        this.devApi = devApi;
    }

    public ArrayList<GetProductsTo> getProductsByMaxPrice(double maxPrice) {
        if (maxPrice < 0) {
            throw new IllegalArgumentException("Max price cannot be negative");
        }

        ArrayList<GetProductsTo> filteredProducts = new ArrayList<>();
        for (GetProductsTo product : products) {
            if (product.getPrice() < maxPrice) {
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }

//    public ArrayList<GetProductsTo> getProductsByProviderId(int idOfProvider) {
//        if (idOfProvider < 0) {
//            throw new IllegalArgumentException("Provider ID cannot be negative");
//        }
//
//        // Not working?
//        ArrayList<GetProductsTo> providerProducts = new ArrayList<>();
//        for (DeliveryAPI api : devApi) {
//            if (api.getIdOfProvider() == idOfProvider) {
//                for (GetProductsTo product : products) {
//                    if (api.getType(idOfProvider).equals(product.getType())) {
//                        providerProducts.add(product);
//                    }
//                }
//            }
//        }
//
//        return providerProducts;
//    }

    public ArrayList<GetProductsTo> getProductsByProviderId(int idOfProvider) {
        if (idOfProvider < 0) {
            throw new IllegalArgumentException("Provider ID cannot be negative");
        }

        return products.stream()
                .filter(product -> product instanceof DeliveryAPI && ((DeliveryAPI) product).getIdOfProvider() == idOfProvider)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
