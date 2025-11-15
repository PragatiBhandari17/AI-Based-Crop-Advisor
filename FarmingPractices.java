package com.example.croprecommendationapp.database;

import java.util.ArrayList;
import java.util.List;

public class FarmingPractices {

    public static class Practice {
        public String title;
        public String description;
        public String benefits;
        public String implementation;
        public String tools;
        public String cost;

        public Practice(String title, String description, String benefits,
                        String implementation, String tools, String cost) {
            this.title = title;
            this.description = description;
            this.benefits = benefits;
            this.implementation = implementation;
            this.tools = tools;
            this.cost = cost;
        }
    }

    public static List<Practice> getAllPractices() {
        List<Practice> practices = new ArrayList<>();

        practices.add(new Practice(
                "Drip Irrigation",
                "Efficient water delivery system supplying water directly to plant roots.",
                "• Saves 30-60% water\n• Increases yield 20-50%\n• Reduces diseases\n• Better fertilizer use",
                "1. Install main pipeline\n2. Layout lateral lines\n3. Place emitters\n4. Connect water source\n5. Test system",
                "Drip pipes, emitters, connectors, filter, pump",
                "₹20,000-50,000 per hectare"
        ));

        practices.add(new Practice(
                "Mulching",
                "Covering soil with organic materials to retain moisture and suppress weeds.",
                "• Reduces water loss 50%\n• Suppresses weeds\n• Improves soil\n• Regulates temperature",
                "1. Clear weeds\n2. Apply 2-4 inch layer\n3. Keep away from stem\n4. Maintain moisture\n5. Refresh as needed",
                "Organic mulch (straw, leaves), plastic sheets",
                "₹5,000-15,000 per hectare"
        ));

        practices.add(new Practice(
                "Crop Rotation",
                "Growing different crops in same field over successive seasons.",
                "• Breaks pest cycles\n• Improves soil nitrogen\n• Reduces disease\n• Increases biodiversity",
                "1. Plan 3-4 year rotation\n2. Alternate crop families\n3. Include legumes\n4. Track history\n5. Monitor soil",
                "Soil testing kit, records, seed varieties",
                "No additional cost"
        ));

        practices.add(new Practice(
                "Organic Farming",
                "Agriculture using natural methods without synthetic chemicals.",
                "• Premium prices 20-40%\n• Healthier soil\n• No residues\n• Growing market",
                "1. Stop chemical inputs\n2. Build compost\n3. Natural pest control\n4. Crop rotation\n5. Get certification",
                "Compost, vermicompost, bio-pesticides, neem",
                "₹10,000-30,000 per hectare/year"
        ));

        practices.add(new Practice(
                "Precision Farming",
                "Using technology like GPS, drones, and sensors for optimization.",
                "• Reduces waste 20-30%\n• Increases yield 15-25%\n• Data-driven decisions\n• ROI in 2-3 years",
                "1. GPS field mapping\n2. Install sensors\n3. Drone monitoring\n4. Collect data\n5. Analyze & optimize",
                "GPS devices, sensors, drones, weather station",
                "₹50,000-2,00,000 per season"
        ));

        practices.add(new Practice(
                "Raised Bed Farming",
                "Growing crops in elevated planting areas with enriched soil.",
                "• Better drainage\n• Warmer soil\n• Better roots\n• Easy maintenance\n• Higher yield",
                "1. Build beds 8-12 inches\n2. Fill with quality soil\n3. Plant crops\n4. Install drip\n5. Apply mulch",
                "Wooden planks, soil, compost, drainage materials",
                "₹30,000-60,000 per hectare"
        ));

        practices.add(new Practice(
                "Integrated Pest Management",
                "Combining multiple pest control strategies to minimize pesticide use.",
                "• Reduces pesticide 50-70%\n• Lower costs\n• Protects beneficials\n• Healthier crops",
                "1. Monitor pests\n2. Use thresholds\n3. Encourage predators\n4. Mechanical removal\n5. Targeted spraying",
                "Pest traps, beneficial insects, neem oil, botanicals",
                "₹5,000-15,000 per hectare/season"
        ));

        practices.add(new Practice(
                "Soil Testing",
                "Regular testing to determine nutrient levels and pH for optimization.",
                "• Optimizes fertilizer\n• Improves quality\n• Prevents deficiency\n• Saves money\n• Increases yield 10-20%",
                "1. Collect samples\n2. Send to lab\n3. Review report\n4. Apply recommendations\n5. Test annually",
                "Soil testing kit, lab analysis, amendments",
                "₹500-1,500 per test"
        ));

        practices.add(new Practice(
                "Composting",
                "Converting organic waste into nutrient-rich compost naturally.",
                "• Reduces waste 90%\n• Free fertilizer\n• Improves soil\n• Increases microbes\n• Sustainable",
                "1. Collect organic waste\n2. Layer materials\n3. Maintain moisture\n4. Turn pile regularly\n5. Use when ready",
                "Compost bin, earthworms, organic waste",
                "₹10,000-25,000 setup"
        ));

        practices.add(new Practice(
                "Greenhouse Farming",
                "Controlled environment agriculture with transparent covering.",
                "• Year-round production\n• Higher yield\n• Water savings 70%\n• Pest control\n• Premium produce",
                "1. Build structure\n2. Install climate control\n3. Set up irrigation\n4. Maintain temp/humidity\n5. Monitor regularly",
                "Greenhouse materials, climate control, drip system",
                "₹3,00,000-5,00,000 per 1000 m²"
        ));

        return practices;
    }
}