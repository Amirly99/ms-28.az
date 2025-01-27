package az.ingress.mapper;

import az.ingress.response.PageableResponse;

import java.util.List;


public enum PageableMapper {
    PAGEABLE_MAPPER;

    public <T> PageableResponse<T> buildPageableResponse(List<T> content, int lasNumber, long totalElements, boolean hasNextPage, int totalPages) {
        var list = content.stream().map(contents -> contents).toList();
        return PageableResponse.<T>builder()
                .content(list)
                .lastPageNumber(lasNumber)
                .totalElements(totalElements)
                .hasNextPage(hasNextPage)
                .build();
    }


}
