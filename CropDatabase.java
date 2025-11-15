package com.example.croprecommendationapp.database;

public class CropDatabase {

    public static class CropInfo {
        public String name;
        public String description;
        public String benefits;
        public String soilRequirements;
        public String climateRequirements;
        public String bestSeason;
        public String yieldPerHectare;
        public String marketPrice;

        public CropInfo(String name, String description, String benefits,
                        String soilRequirements, String climateRequirements,
                        String bestSeason, String yieldPerHectare, String marketPrice) {
            this.name = name;
            this.description = description;
            this.benefits = benefits;
            this.soilRequirements = soilRequirements;
            this.climateRequirements = climateRequirements;
            this.bestSeason = bestSeason;
            this.yieldPerHectare = yieldPerHectare;
            this.marketPrice = marketPrice;
        }
    }

    public static CropInfo getCropInfo(String cropName) {
        switch(cropName.toLowerCase()) {
            case "rice":
                return new CropInfo(
                        "Rice",
                        "Rice is a staple grain crop that feeds more than half the world's population.",
                        "• High energy source\n• Rich in vitamins\n• Gluten-free\n• Versatile crop",
                        "pH: 5.0-7.0 | N: 80-120 ppm | P: 40-60 ppm | K: 40-80 ppm",
                        "Temp: 20-30°C | Humidity: 60-100% | Rainfall: 150-225 mm",
                        "June to October (Kharif)",
                        "45-70 quintals/hectare",
                        "₹1500-2000 per quintal"
                );

            case "wheat":
                return new CropInfo(
                        "Wheat",
                        "Wheat is a cool-season cereal crop and major food staple worldwide.",
                        "• High protein\n• Rich in fiber\n• Essential minerals\n• Long storage",
                        "pH: 6.0-7.8 | N: 80-100 ppm | P: 50-80 ppm | K: 60-100 ppm",
                        "Temp: 15-27°C | Humidity: 40-80% | Rainfall: 50-250 mm",
                        "October to March (Rabi)",
                        "40-60 quintals/hectare",
                        "₹1800-2200 per quintal"
                );

            case "maize":
                return new CropInfo(
                        "Maize",
                        "Maize is a versatile cereal used for food, feed, and industrial purposes.",
                        "• High yield crop\n• Multiple uses\n• Rich in carbs\n• Biofuel source",
                        "pH: 6.0-7.0 | N: 100-150 ppm | P: 50-80 ppm | K: 80-120 ppm",
                        "Temp: 20-30°C | Humidity: 60-100% | Rainfall: 200-300 mm",
                        "March to June or June to September",
                        "50-80 quintals/hectare",
                        "₹1400-1800 per quintal"
                );

            case "cotton":
                return new CropInfo(
                        "Cotton",
                        "Cotton is a valuable fiber crop used in textile production.",
                        "• Premium fiber\n• High market value\n• Oil from seeds\n• Export quality",
                        "pH: 6.0-7.5 | N: 60-120 ppm | P: 40-60 ppm | K: 60-100 ppm",
                        "Temp: 20-30°C | Humidity: 50-90% | Rainfall: 100-200 mm",
                        "March to October",
                        "15-25 quintals/hectare",
                        "₹4500-6000 per quintal"
                );

            case "sugarcane":
                return new CropInfo(
                        "Sugarcane",
                        "Sugarcane is a cash crop used to produce sugar and ethanol.",
                        "• High sugar yield\n• Ethanol production\n• Jaggery making\n• Good income",
                        "pH: 5.5-7.5 | N: 100-150 ppm | P: 60-100 ppm | K: 100-150 ppm",
                        "Temp: 18-28°C | Humidity: 50-85% | Rainfall: 100-250 mm",
                        "October to May",
                        "60-100 tonnes/hectare",
                        "₹280-350 per quintal"
                );

            case "potato":
                return new CropInfo(
                        "Potato",
                        "Potato is a major staple food crop with high productivity.",
                        "• Rich in Vitamin C\n• High potassium\n• Quick harvest\n• Multiple uses",
                        "pH: 5.0-7.0 | N: 80-120 ppm | P: 60-100 ppm | K: 100-150 ppm",
                        "Temp: 15-25°C | Humidity: 60-100% | Rainfall: 150-300 mm",
                        "October to February",
                        "200-300 quintals/hectare",
                        "₹800-1200 per quintal"
                );

            case "sorghum":
                return new CropInfo(
                        "Sorghum",
                        "Sorghum is a drought-resistant cereal crop for dry regions.",
                        "• Drought tolerant\n• Animal fodder\n• Grain for food\n• Low input cost",
                        "pH: 5.5-7.5 | N: 60-100 ppm | P: 30-50 ppm | K: 40-60 ppm",
                        "Temp: 20-35°C | Humidity: 40-80% | Rainfall: 50-150 mm",
                        "June to September",
                        "20-40 quintals/hectare",
                        "₹1200-1500 per quintal"
                );

            case "groundnut":
                return new CropInfo(
                        "Groundnut",
                        "Groundnut is an oil seed crop rich in protein and oil.",
                        "• High protein\n• Healthy oils\n• Nitrogen fixing\n• Export quality",
                        "pH: 5.5-7.5 | N: 20-40 ppm | P: 40-60 ppm | K: 40-80 ppm",
                        "Temp: 25-35°C | Humidity: 40-80% | Rainfall: 40-100 mm",
                        "May to August",
                        "20-35 quintals/hectare",
                        "₹4000-5500 per quintal"
                );

            case "soybean":
                return new CropInfo(
                        "Soybean",
                        "Soybean is a versatile legume crop rich in protein.",
                        "• High protein 35-40%\n• Healthy fats\n• Nitrogen fixing\n• Animal feed",
                        "pH: 6.0-7.5 | N: 0-20 ppm | P: 60-80 ppm | K: 80-100 ppm",
                        "Temp: 20-30°C | Humidity: 50-85% | Rainfall: 100-250 mm",
                        "June to September",
                        "15-25 quintals/hectare",
                        "₹3500-4500 per quintal"
                );

            default:
                return new CropInfo(
                        "Unknown",
                        "Information not available",
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""
                );
        }
    }
}