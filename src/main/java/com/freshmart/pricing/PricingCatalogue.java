package com.freshmart.pricing;

import com.freshmart.model.Category;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/** Chooses the {@link PricingStrategy} used for each category. */
public final class PricingCatalogue {
    private final Map<Category, PricingStrategy> strategies;

    private PricingCatalogue(Map<Category, PricingStrategy> strategies) {
        this.strategies = strategies;
    }

    /** The rates in Table 1 of the case study. */
    public static PricingCatalogue standard() {
        Map<Category, PricingStrategy> map = new EnumMap<>(Category.class);
        map.put(Category.VEGETABLES, new VegetablePricing());
        map.put(Category.FRUITS, new FruitPricing());
        map.put(Category.DAIRY, new DairyPricing());
        map.put(Category.HOUSEHOLD_ESSENTIALS, new HouseholdPricing());
        return new PricingCatalogue(map);
    }

    /** A copy of this catalogue with a different strategy for one category. */
    public PricingCatalogue with(Category category, PricingStrategy strategy) {
        Map<Category, PricingStrategy> copy = new EnumMap<>(strategies);
        copy.put(category, Objects.requireNonNull(strategy));
        return new PricingCatalogue(copy);
    }

    public PricingStrategy of(Category category) {
        return Objects.requireNonNull(strategies.get(category), () -> "No pricing strategy for " + category);
    }
}
