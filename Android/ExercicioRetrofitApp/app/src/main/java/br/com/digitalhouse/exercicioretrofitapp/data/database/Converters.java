package br.com.digitalhouse.exercicioretrofitapp.data.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import br.com.digitalhouse.exercicioretrofitapp.model.Dob;
import br.com.digitalhouse.exercicioretrofitapp.model.Id;
import br.com.digitalhouse.exercicioretrofitapp.model.Location;
import br.com.digitalhouse.exercicioretrofitapp.model.Login;
import br.com.digitalhouse.exercicioretrofitapp.model.Name;
import br.com.digitalhouse.exercicioretrofitapp.model.Picture;
import br.com.digitalhouse.exercicioretrofitapp.model.Registered;

public class Converters {
    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }

    /// Type converter para uam lista de String
    @TypeConverter
    public List<String> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    /// Type converter para uam lista de String
    @TypeConverter
    public Dob fromDob(String value) {
        Type listType = (Type) new TypeToken<Dob>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromDob(Dob dob) {
        Gson gson = new Gson();
        return gson.toJson(dob);
    }

    /// Type converter para uam lista de String
    @TypeConverter
    public Id fromId(String value) {
        Type listType = (Type) new TypeToken<Id>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromId(Id id) {
        Gson gson = new Gson();
        return gson.toJson(id);
    }

    /// Type converter para uam lista de String
    @TypeConverter
    public Location fromLocation(String value) {
        Type listType = (Type) new TypeToken<Location>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromLocation(Location location) {
        Gson gson = new Gson();
        return gson.toJson(location);
    }

    /// Type converter para uam lista de String
    @TypeConverter
    public Login fromLogin(String value) {
        Type listType = (Type) new TypeToken<Login>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromLogin(Login login) {
        Gson gson = new Gson();
        return gson.toJson(login);
    }

    /// Type converter para uam lista de String
    @TypeConverter
    public Name fromName(String value) {
        Type listType = (Type) new TypeToken<Name>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromName(Name name) {
        Gson gson = new Gson();
        return gson.toJson(name);
    }

    /// Type converter para uam lista de String
    @TypeConverter
    public Picture fromPicture(String value) {
        Type listType = (Type) new TypeToken<Picture>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromPicture(Picture picture) {
        Gson gson = new Gson();
        return gson.toJson(picture);
    }

    /// Type converter para uam lista de String
    @TypeConverter
    public Registered fromRegistered(String value) {
        Type listType = (Type) new TypeToken<Registered>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromRegistered(Registered registered) {
        Gson gson = new Gson();
        return gson.toJson(registered);
    }
}
