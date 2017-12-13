package edu.olya.tour.dao;

import edu.olya.tour.model.Country;
import edu.olya.tour.model.Hotel;
import edu.olya.tour.model.MealType;
import edu.olya.tour.model.TourType;
import edu.olya.tour.utils.database.AbstractDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object class implements CountryDao interface
 */
public class FilterDAOImpl extends AbstractDAO implements FilterDAO {
    //todo индексы в rs.getInt и т.п. должны быть заменены на имена колонок
    @Override
    public List<Country> getAllCountries() {
        return executeQuery("SELECT id, country FROM countries", new RowCreator<Country>(){
            public  Country buildRow(ResultSet rs)throws SQLException{
                return new Country(rs.getInt(1), rs.getString(2));
            }
        });
    }

    @Override
    public List<TourType> getAllTourTypes(){
        return executeQuery("SELECT id, tour_type FROM tour_types", new RowCreator<TourType>(){
            public  TourType buildRow(ResultSet rs)throws SQLException{
                return new TourType(rs.getInt(1), rs.getString(2));
            }
        });
    }

    @Override
    public List<MealType> getAllMealTypes(){
        return executeQuery("SELECT id, meal_type FROM meal_types", new RowCreator<MealType>(){
            public  MealType buildRow(ResultSet rs)throws SQLException{
                return new MealType(rs.getInt(1), rs.getString(2));
            }
        });
    }

    @Override
    public List<Hotel> getAllHotels(){
        return executeQuery("SELECT id, hotel FROM hotels", new RowCreator<Hotel>(){
            public  Hotel buildRow(ResultSet rs)throws SQLException{
                return new Hotel(rs.getInt(1), rs.getString(2));
            }
        });
    }
}





