package org.converter.units.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.converter.units.data.model.UnitDto

const val BASE_URL = "https://gist.githubusercontent.com/Kudlayra/448f4c75d4b4edba89df5844a1c91438/raw/a64c20cf224df22dc4a7104154e1ec45ac679631/gistfile1.txt"

class KtorUnitsRemoteDataSource(private val api: HttpClient) : UnitsRemoteDataSource {
    override suspend fun getUnitList(): List<UnitDto>? {
        return api.get(BASE_URL).body()
    }
}