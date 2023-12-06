package ag.selm.catalogue.spi.spring.jdbc;

import ag.selm.catalogue.data.ProductCategoryData;
import ag.selm.catalogue.id.ProductCategoryId;
import ag.selm.catalogue.spi.FindProductCategoryByIdSpi;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Optional;

public class MappingSqlQueryFindProductCategoryById
        extends MappingSqlQuery<ProductCategoryData> implements FindProductCategoryByIdSpi {

    public MappingSqlQueryFindProductCategoryById(DataSource ds) {
        super(ds, """
                select id, c_title, c_details, id_parent, c_version
                from catalogue.v_product_category_v1
                where id = :id
                """);
        this.declareParameter(new SqlParameter("id", Types.BIGINT));
        this.compile();
    }

    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id) {
        return Optional.ofNullable(this.findObjectByNamedParam(Map.of("id", id.value())));
    }

    @Override
    protected ProductCategoryData mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductCategoryData(new ProductCategoryId(rs.getLong("id")),
                rs.getString("c_title"), rs.getString("c_details"),
                ProductCategoryId.fromLong(rs.getLong("id_parent")),
                rs.getInt("c_version"));
    }
}
