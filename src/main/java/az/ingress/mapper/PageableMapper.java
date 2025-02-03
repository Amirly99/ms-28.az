package az.ingress.mapper;

import az.ingress.entity.lab.CreditsEntity;
import az.ingress.response.PageableResponse;
import liquibase.pro.packaged.T;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

@Slf4j

public enum PageableMapper {
    PAGEABLE_MAPPER;

    public static <T> PageableResponse <T> buildPageableResponse(List<T> content, int lastPageNumber, long totalElements, boolean hasNextPage) {
        // var list = content.stream().toList();
       // log.info("ActionLog.buildPageableResponse.content: {} ", content);
        return PageableResponse.<T>builder()
                .content(List.copyOf(Objects.requireNonNull(content, "Not cannot")))
                .lastPageNumber(lastPageNumber)
                .totalElements(totalElements)
                .hasNextPage(hasNextPage)
                .build();
    }


}
