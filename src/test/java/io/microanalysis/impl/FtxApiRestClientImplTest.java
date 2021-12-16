package io.microanalysis.impl;

import io.microanalysis.FtxApiClientFactory;
import io.microanalysis.FtxApiRestClient;
import io.microanalysis.domain.Response;
import io.microanalysis.domain.general.Asset;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class FtxApiRestClientImplTest {

    private final FtxApiRestClient ftxApiRestClient = FtxApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        Response<List<Asset>> response = ftxApiRestClient.getAssets();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }
}