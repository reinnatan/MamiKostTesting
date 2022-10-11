package mamikost.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DriverBuilderFactory {

        private static final Map<DriverType, DriverBuilder> driverBuilder = new HashMap<>();

        @Autowired
        private DriverBuilderFactory(List<DriverBuilder> driverBuilders) {
            for (DriverBuilder builder : driverBuilders) {
                System.out.println("Type : "+builder.getType());
                driverBuilder.put(builder.getType(), builder);
            }
        }

        public static DriverBuilder getDriver(DriverType type){
            DriverBuilder builder = driverBuilder.get(type);
            if(builder == null)
                throw new IllegalArgumentException("Unknown Driver Type : "+type);
            return builder;
        }
}
