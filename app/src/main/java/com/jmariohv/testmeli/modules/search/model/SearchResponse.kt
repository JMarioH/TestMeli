package com.jmariohv.testmeli.modules.search.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("site_id"                   ) var siteId                 : String?           = null,
    @SerializedName("country_default_time_zone" ) var countryDefaultTimeZone : String?           = null,
    @SerializedName("query"                     ) var query                  : String?           = null,
    @SerializedName("paging"                    ) var paging                 : Paging?           = Paging(),
    @SerializedName("results"                   ) var results                : ArrayList<Results> = arrayListOf(),
    @SerializedName("sort"                      ) var sort                   : Sort?             = Sort(),
    @SerializedName("available_sorts"           ) var availableSorts         : ArrayList<AvailableSorts> = arrayListOf(),
    @SerializedName("filters"                   ) var filters                : ArrayList<Filters> = arrayListOf(),
    @SerializedName("available_filters"         ) var availableFilters       : ArrayList<AvailableFilters> = arrayListOf(),
    @SerializedName("pads_info"                 ) var padsInfo               : PadsInfo?         = PadsInfo()
)

data class Results (

    @SerializedName("id"                  ) var id                 : String?               = null,
    @SerializedName("title"               ) var title              : String?               = "",
    @SerializedName("condition"           ) var condition          : String?               = null,
    @SerializedName("thumbnail_id"        ) var thumbnailId        : String?               = null,
    @SerializedName("catalog_product_id"  ) var catalogProductId   : String?               = null,
    @SerializedName("listing_type_id"     ) var listingTypeId      : String?               = null,
    @SerializedName("permalink"           ) var permalink          : String?               = null,
    @SerializedName("buying_mode"         ) var buyingMode         : String?               = null,
    @SerializedName("site_id"             ) var siteId             : String?               = null,
    @SerializedName("category_id"         ) var categoryId         : String?               = null,
    @SerializedName("domain_id"           ) var domainId           : String?               = null,
    @SerializedName("variation_id"        ) var variationId        : String?               = null,
    @SerializedName("thumbnail"           ) var thumbnail          : String?               = null,
    @SerializedName("currency_id"         ) var currencyId         : String?               = null,
    @SerializedName("order_backend"       ) var orderBackend       : Int?                  = null,
    @SerializedName("price"               ) var price              : Double?                  = null,
    @SerializedName("original_price"      ) var originalPrice      : String?               = null,
    @SerializedName("sale_price"          ) var salePrice          : String?               = null,
    @SerializedName("sold_quantity"       ) var soldQuantity       : Int?                  = null,
    @SerializedName("available_quantity"  ) var availableQuantity  : Int?                  = null,
    @SerializedName("official_store_id"   ) var officialStoreId    : String?               = null,
    @SerializedName("use_thumbnail_id"    ) var useThumbnailId     : Boolean?              = null,
    @SerializedName("accepts_mercadopago" ) var acceptsMercadopago : Boolean?              = null,
    @SerializedName("tags"                ) var tags               : ArrayList<String>     = arrayListOf(),
    @SerializedName("variation_filters"   ) var variationFilters   : ArrayList<String>     = arrayListOf(),
    @SerializedName("shipping"            ) var shipping           : Shipping?             = Shipping(),
    @SerializedName("stop_time"           ) var stopTime           : String?               = null,
    @SerializedName("seller"              ) var seller             : Seller?               = Seller(),
    @SerializedName("seller_address"      ) var sellerAddress      : SellerAddress?        = SellerAddress(),
    @SerializedName("address"             ) var address            : Address?              = Address(),
    @SerializedName("installments"        ) var installments       : Installments?         = Installments(),
    @SerializedName("winner_item_id"      ) var winnerItemId       : String?               = null,
    @SerializedName("catalog_listing"     ) var catalogListing     : Boolean?              = null,
    @SerializedName("discounts"           ) var discounts          : String?               = null,
    @SerializedName("promotions"          ) var promotions         : ArrayList<String>     = arrayListOf(),
    @SerializedName("inventory_id"        ) var inventoryId        : String?               = null

)
data class Paging (
    @SerializedName("total"           ) var total          : Int? = null,
    @SerializedName("primary_results" ) var primaryResults : Int? = null,
    @SerializedName("offset"          ) var offset         : Int? = null,
    @SerializedName("limit"           ) var limit          : Int? = null
)
data class Sort(
    @SerializedName("id"           ) var id          : String? = null,
    @SerializedName("name"         ) var name        : String? = null,
)
data class PadsInfo (
    @SerializedName("tracelog" ) var tracelog : ArrayList<String> = arrayListOf()
)
data class AvailableSorts (
    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null
)

data class Filters(
    @SerializedName("id"     ) var id     : String?           = null,
    @SerializedName("name"   ) var name   : String?           = null,
    @SerializedName("type"   ) var type   : String?           = null,
    @SerializedName("values" ) var values : ArrayList<Values> = arrayListOf()
)
data class Values (

    @SerializedName("id"             ) var id           : String?                 = null,
    @SerializedName("name"           ) var name         : String?                 = null,
    @SerializedName("path_from_root" ) var pathFromRoot : ArrayList<PathFromRoot> = arrayListOf()

)
data class PathFromRoot (

    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null

)
data class AvailableFilters (

    @SerializedName("id"     ) var id     : String?           = null,
    @SerializedName("name"   ) var name   : String?           = null,
    @SerializedName("type"   ) var type   : String?           = null,
    @SerializedName("values" ) var values : ArrayList<Values> = arrayListOf()

)

data class Shipping (

    @SerializedName("store_pick_up" ) var storePickUp  : Boolean?          = null,
    @SerializedName("free_shipping" ) var freeShipping : Boolean?          = null,
    @SerializedName("logistic_type" ) var logisticType : String?           = null,
    @SerializedName("mode"          ) var mode         : String?           = null,
    @SerializedName("tags"          ) var tags         : ArrayList<String> = arrayListOf(),
    @SerializedName("benefits"      ) var benefits     : String?           = null,
    @SerializedName("promise"       ) var promise      : String?           = null

)

data class Seller (

    @SerializedName("id"                 ) var id               : Int?              = null,
    @SerializedName("nickname"           ) var nickname         : String?           = null,
    @SerializedName("car_dealer"         ) var carDealer        : Boolean?          = null,
    @SerializedName("real_estate_agency" ) var realEstateAgency : Boolean?          = null,
    @SerializedName("registration_date"  ) var registrationDate : String?           = null,
    @SerializedName("tags"               ) var tags             : ArrayList<String> = arrayListOf(),
    @SerializedName("car_dealer_logo"    ) var carDealerLogo    : String?           = null,
    @SerializedName("permalink"          ) var permalink        : String?           = null,
    @SerializedName("seller_reputation"  ) var sellerReputation : SellerReputation? = SellerReputation()

)

data class SellerReputation (

    @SerializedName("level_id"            ) var levelId           : String?       = null,
    @SerializedName("power_seller_status" ) var powerSellerStatus : String?       = null,
    @SerializedName("transactions"        ) var transactions      : Transactions? = Transactions(),


)
data class Metrics (

    @SerializedName("sales"                 ) var sales               : Sales?               = Sales(),
    @SerializedName("claims"                ) var claims              : Claims?              = Claims(),
    @SerializedName("delayed_handling_time" ) var delayedHandlingTime : DelayedHandlingTime? = DelayedHandlingTime(),
    @SerializedName("cancellations"         ) var cancellations       : Cancellations?       = Cancellations()

)

data class Transactions (

    @SerializedName("canceled"  ) var canceled  : Int?     = null,
    @SerializedName("completed" ) var completed : Int?     = null,
    @SerializedName("period"    ) var period    : String?  = null,
    @SerializedName("ratings"   ) var ratings   : Ratings? = Ratings(),
    @SerializedName("total"     ) var total     : Int?     = null

)
data class Ratings (

    @SerializedName("negative" ) var negative : Double? = null,
    @SerializedName("neutral"  ) var neutral  : Double? = null,
    @SerializedName("positive" ) var positive : Double? = null

)
data class Sales (

    @SerializedName("period"    ) var period    : String? = null,
    @SerializedName("completed" ) var completed : Int?    = null

)
data class Claims (

    @SerializedName("period" ) var period : String? = null,
    @SerializedName("rate"   ) var rate   : Int?    = null,
    @SerializedName("value"  ) var value  : Int?    = null

)
data class DelayedHandlingTime (

    @SerializedName("period" ) var period : String? = null,
    @SerializedName("rate"   ) var rate   : Int?    = null,
    @SerializedName("value"  ) var value  : Int?    = null

)
data class Cancellations (

    @SerializedName("period" ) var period : String? = null,
    @SerializedName("rate"   ) var rate   : Int?    = null,
    @SerializedName("value"  ) var value  : Int?    = null

)
data class Installments (

    @SerializedName("quantity"    ) var quantity   : Int?    = null,
    @SerializedName("amount"      ) var amount     : Double?    = null,
    @SerializedName("rate"        ) var rate       : Double? = null,
    @SerializedName("currency_id" ) var currencyId : String? = null

)
data class Attributes (

    @SerializedName("id"                   ) var id                 : String?           = null,
    @SerializedName("name"                 ) var name               : String?           = null,
    @SerializedName("value_id"             ) var valueId            : String?           = null,
    @SerializedName("value_name"           ) var valueName          : String?           = null,
    @SerializedName("attribute_group_id"   ) var attributeGroupId   : String?           = null,
    @SerializedName("attribute_group_name" ) var attributeGroupName : String?           = null,
    @SerializedName("value_struct"         ) var valueStruct        : String?           = null,
    @SerializedName("values"               ) var values             : ArrayList<Values> = arrayListOf(),
    @SerializedName("source"               ) var source             : Int?              = null,
    @SerializedName("value_type"           ) var valueType          : String?           = null

)

data class Address (

    @SerializedName("state_id"   ) var stateId   : String? = null,
    @SerializedName("state_name" ) var stateName : String? = null,
    @SerializedName("city_id"    ) var cityId    : String? = null,
    @SerializedName("city_name"  ) var cityName  : String? = null

)
data class SellerAddress (

    @SerializedName("comment"      ) var comment     : String?  = null,
    @SerializedName("address_line" ) var addressLine : String?  = null,
    @SerializedName("id"           ) var id          : String?  = null,
    @SerializedName("latitude"     ) var latitude    : String?  = null,
    @SerializedName("longitude"    ) var longitude   : String?  = null,
    @SerializedName("country"      ) var country     : Country? = Country(),
    @SerializedName("state"        ) var state       : State?   = State(),
    @SerializedName("city"         ) var city        : City?    = City()

)

data class Country (

    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null

)


data class City (

    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null

)
data class State (

    @SerializedName("id"   ) var id   : String? = null,
    @SerializedName("name" ) var name : String? = null

)