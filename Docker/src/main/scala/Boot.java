import java.io.File

import com.amazonaws.auth.AWSStaticCredentialsProvider

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.{Bucket, GetObjectRequest}
import org.slf4j.LoggerFactory
import week10.AmazonS3Example.{bucketName, client}

import collection.JavaConverters._

object Boot extends App {

        val log = LoggerFactory.getLogger("Boot")

        val awsCreds = new BasicAWSCredentials(
        "AKIAZ622MCAJCAH6G2LK",
        "cfbDVxVrSpL9CnAphKdkubTeK9D2+RJ4tMzkrbZO")

//  AwsClientBuilder.setEndpointConfiguration(AwsClientBuilder.EndpointConfiguration)


        // Frankfurt client
        val s3Client: AmazonS3 = AmazonS3ClientBuilder.standard
        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
        .withRegion(Regions.US_WEST_2)
        .build

        // check if bucket exists

        if (s3Client.doesBucketExistV2("task1-bucket")) {
        log.info("Bucket exists")
        }

        // get all objects

        val buckets = s3Client.listBuckets().asScala.toList
        buckets.foreach(b => log.info(s"Bucket: ${b.getName}"))

        // create a bucket
        if (s3Client.doesBucketExistV2("task1-bucket")) {
        log.info("this exists")
        } else {
        s3Client.createBucket("task1-bucket")
        }

        // Add file


        val file = new File("src/main/resources/s3/in/ex3.txt")
        log.info(s"Putting file: ${file.getAbsolutePath}")
        s3Client.putObject("task1-bucket", file.getName, file)



        val file2 = new File("src/main/resources/s3/out/ex3.txt")



        s3Client.getObject(new GetObjectRequest("task1-bucket", file2.getName),file2)
        log.info(s"Downloading file: ${file2.getAbsolutePath}")



        }
