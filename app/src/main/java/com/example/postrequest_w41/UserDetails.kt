package com.example.postrequest_w41

import com.google.gson.annotations.SerializedName

class UserDetails {
  //  @SerializedName("Accept")
    var data:List<Dutum>?=null

    class Dutum {
        @SerializedName("name")
        var name:String?=null

        @SerializedName("location")
        var location:String?=null

        constructor(name: String?, location: String?) {
            this.name = name
            this.location = location
        }

    }

}