package hu.bme.aut.hw_spaceinvaders.Senzor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import hu.bme.aut.hw_spaceinvaders.GameClasses.Game

class GyroscopeHelper(context: Context) : SensorEventListener {
    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    private val magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

    private val lastAccelerometerValue = FloatArray(3)
    private val lastMagnetometerValue = FloatArray(3)

    private var lastAccelerometerSet = false
    private var lastMagnetometerSet = false

    private val rotation = FloatArray(9)
    private val orientation = FloatArray(3)

    fun start() {
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_FASTEST)
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_FASTEST)
    }

    fun stop() {
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {
        when (event.sensor) {
            accelerometer -> {
                System.arraycopy(event.values, 0, lastAccelerometerValue, 0, event.values.size)
                lastAccelerometerSet = true
            }
            magnetometer -> {
                System.arraycopy(event.values, 0, lastMagnetometerValue, 0, event.values.size)
                lastMagnetometerSet = true
            }
        }
        if (lastAccelerometerSet && lastMagnetometerSet) {
            SensorManager.getRotationMatrix(rotation, null, lastAccelerometerValue, lastMagnetometerValue)
            SensorManager.getOrientation(rotation, orientation)

            val roll = orientation[2] * 1.0f
            Game.setPlayerVel(roll)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
}
