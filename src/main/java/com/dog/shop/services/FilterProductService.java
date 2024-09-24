package com.dog.shop.services;

/*
@Service
public class FilterProductService {
    private final ProductRepository<Product> productRepository;

    @Autowired
    public FilterProductService(ProductRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    // metod för att filtrera produkter baserat på parametrar
    public List<Product> filterProducts(Map<String, String> params) {
        String productTypeAlias = getProductType(params.get("productType"));

      Map<String, ProductFilter<Product>>  filters = FilterRegistry.getFiltersForType((getProductClassFromAlias(productTypeAlias)));

      List<Predicate<Product>> predicates = params.entrySet().stream()
              .filter(entry -> filters.containsKey(entry.getKey()))
              .map(entry ->{
                  String paramName = entry.getKey();
                  String paramValue = entry.getValue();
                  return filters.get(paramName).apply(paramValue);
              })
              .toList();

      Predicate<Product> combinedPredicate = predicates.stream()
              .reduce(product -> true, Predicate::and);

      List<Product> allProducts = fetchProductsByType(productTypeAlias);

      return allProducts.stream()
              .filter(combinedPredicate)
              .collect(Collectors.toList());
    }

    // hjälpmetod för att avgöra produktens typ alias från ens sträng
    private String getProductType(String typeName) {
        if (typeName == null || typeName.isEmpty()) {
            return "product";
        }
        switch(typeName.toLowerCase()) {
            case "collar":
                return "collarProduct";
            case "leash":
                return "leashProduct";
            case "toy":
                return "toyProduct";
            case "bowl":
                return "bowlProduct";
            default:
                throw new IllegalArgumentException("Unknown product type " + typeName);
        }
    }

    // hjälpmetod för att hämta produkter by type alias
    private List<Product> fetchProductsByType (String productTypeAlias) {
        return productRepository.findByProductType(productTypeAlias);
    }

    // hjälpmetod som hjälper till att hämta klassen från alias (FilterRegistry lookup)
    private Class<? extends Product> getProductClassFromAlias(String alias) {
        switch (alias) {
            case "collarProduct":
                return Collar.class;
            case "leashProduct":
                return Leash.class;
            case "toyProduct":
                return Toy.class;
            case "bowlProduct":
                return Bowl.class;
            default:
                return Product.class;
        }
    }
}









*/




















