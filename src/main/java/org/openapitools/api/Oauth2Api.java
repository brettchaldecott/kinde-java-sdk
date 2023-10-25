/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.UserProfile;
import org.openapitools.model.UserProfileV2;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-08T18:38:44.963952+05:00[Asia/Karachi]")
@Validated
@Tag(name = "OAuth", description = "the OAuth API")
public interface Oauth2Api {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /oauth2/user_profile : Get User Profile
     * Contains the id, names and email of the currently logged in user. 
     *
     * @return Details of logged in user V1. (status code 200)
     *         or Invalid credentials. (status code 403)
     */
    @Operation(
        operationId = "getUser",
        summary = "Get User Profile",
        description = "Contains the id, names and email of the currently logged in user. ",
        tags = { "OAuth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Details of logged in user V1.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfile.class))
            }),
            @ApiResponse(responseCode = "403", description = "Invalid credentials.")
        },
        security = {
            @SecurityRequirement(name = "kindeBearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/oauth2/user_profile",
        produces = { "application/json" }
    )
    default ResponseEntity<UserProfile> getUser(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"preferred_email\" : \"preferred_email\", \"last_name\" : \"last_name\", \"id\" : \"id\", \"provided_id\" : \"provided_id\", \"first_name\" : \"first_name\", \"picture\" : \"picture\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /oauth2/v2/user_profile : Returns the details of the currently logged in user
     * Contains the id, names, profile picture URL and email of the currently logged in user. 
     *
     * @return Details of logged in user V2. (status code 200)
     *         or Invalid credentials. (status code 403)
     */
    @Operation(
        operationId = "getUserProfileV2",
        summary = "Returns the details of the currently logged in user",
        description = "Contains the id, names, profile picture URL and email of the currently logged in user. ",
        tags = { "OAuth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Details of logged in user V2.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserProfileV2.class))
            }),
            @ApiResponse(responseCode = "403", description = "Invalid credentials.")
        },
        security = {
            @SecurityRequirement(name = "kindeBearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/oauth2/v2/user_profile",
        produces = { "application/json" }
    )
    default ResponseEntity<UserProfileV2> getUserProfileV2(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"sub\" : \"sub\", \"updated_at\" : 0, \"name\" : \"name\", \"id\" : \"id\", \"given_name\" : \"given_name\", \"provided_id\" : \"provided_id\", \"family_name\" : \"family_name\", \"email\" : \"email\", \"picture\" : \"picture\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
